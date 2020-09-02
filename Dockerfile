
# Check for latest version here: https://hub.docker.com/_/buildpack-deps?tab=tags&page=1&name=buster&ordering=last_updated
# This is just a snapshot of buildpack-deps:buster that was last updated on 2019-12-28.

#Abhiram : this is taken from https://github.com/judge0/api-base/blob/v1.2.1/Dockerfile

FROM judge0/buildpack-deps:buster-2019-12-28

# Check for latest version here: https://jdk.java.net
RUN set -xe && \
    curl -fSsL "https://download.java.net/java/GA/jdk13.0.1/cec27d702aa74d5a8630c65ae61e4305/9/GPL/openjdk-13.0.1_linux-x64_bin.tar.gz" -o /tmp/openjdk13.tar.gz && \
    mkdir /usr/local/openjdk13 && \
    tar -xf /tmp/openjdk13.tar.gz -C /usr/local/openjdk13 --strip-components=1 && \
    rm /tmp/openjdk13.tar.gz && \
    ln -s /usr/local/openjdk13/bin/javac /usr/local/bin/javac && \
    ln -s /usr/local/openjdk13/bin/java /usr/local/bin/java && \
    ln -s /usr/local/openjdk13/bin/jar /usr/local/bin/jar



# JUnit Platform Console Standalone
RUN set -xe && \
    mkdir /usr/local/junit-platform-console-standalone-1.6.2 && \
    cd /usr/local/junit-platform-console-standalone-1.6.2 && \
    curl -fSsL "https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.6.2/junit-platform-console-standalone-1.6.2.jar" -o launcher.jar

# Add junit related libraries

ADD java-libs/    /usr/local/java-libs/

# Check for latest version here: https://ftpmirror.gnu.org/bash
ENV BASH_VERSIONS \
      5.0
RUN set -xe && \
    for VERSION in $BASH_VERSIONS; do \
      curl -fSsL "https://ftpmirror.gnu.org/bash/bash-$VERSION.tar.gz" -o /tmp/bash-$VERSION.tar.gz && \
      mkdir /tmp/bash-$VERSION && \
      tar -xf /tmp/bash-$VERSION.tar.gz -C /tmp/bash-$VERSION --strip-components=1 && \
      rm /tmp/bash-$VERSION.tar.gz && \
      cd /tmp/bash-$VERSION && \
      ./configure \
        --prefix=/usr/local/bash-$VERSION && \
      make -j$(nproc) && \
      make -j$(nproc) install && \
      rm -rf /tmp/*; \
    done

# Check for latest version here: https://packages.debian.org/buster/sqlite3
# Used for support of SQLite.
RUN set -xe && \
    apt-get update && \
    apt-get install -y --no-install-recommends sqlite3 && \
    rm -rf /var/lib/apt/lists/*

RUN set -xe && \
    apt-get update && \
    apt-get install -y --no-install-recommends locales && \
    rm -rf /var/lib/apt/lists/* && \
    echo "en_US.UTF-8 UTF-8" > /etc/locale.gen && \
    locale-gen
ENV LANG=en_US.UTF-8 LANGUAGE=en_US:en LC_ALL=en_US.UTF-8

RUN set -xe && \
    apt-get update && \
    apt-get install -y --no-install-recommends git libcap-dev && \
    rm -rf /var/lib/apt/lists/* && \
    git clone https://github.com/judge0/isolate.git /tmp/isolate && \
    cd /tmp/isolate && \
    git checkout c43acde2bde22b0f18ec5e3a0f3ebd66d96b0bee && \
    make -j$(nproc) install && \
    rm -rf /tmp/*




COPY /tests   /tests


ENV BOX_ROOT /var/local/lib/isolate

# mysql related change over

# Adding mysql related docker changes. taken from https://github.com/mysql/mysql-docker/tree/mysql-server/8.0


# add our user and group first to make sure their IDs get assigned consistently, regardless of whatever dependencies get added
RUN groupadd -r mysql && useradd -r -g mysql mysql

RUN apt-get update && apt-get install -y --no-install-recommends gnupg dirmngr && rm -rf /var/lib/apt/lists/*

# add gosu for easy step-down from root
# https://github.com/tianon/gosu/releases
ENV GOSU_VERSION 1.12
RUN set -eux; \
	savedAptMark="$(apt-mark showmanual)"; \
	apt-get update; \
	apt-get install -y --no-install-recommends ca-certificates wget; \
	rm -rf /var/lib/apt/lists/*; \
	dpkgArch="$(dpkg --print-architecture | awk -F- '{ print $NF }')"; \
	wget -O /usr/local/bin/gosu "https://github.com/tianon/gosu/releases/download/$GOSU_VERSION/gosu-$dpkgArch"; \
	wget -O /usr/local/bin/gosu.asc "https://github.com/tianon/gosu/releases/download/$GOSU_VERSION/gosu-$dpkgArch.asc"; \
	export GNUPGHOME="$(mktemp -d)"; \
	gpg --batch --keyserver hkps://keys.openpgp.org --recv-keys B42F6819007F00F88E364FD4036A9C25BF357DD4; \
	gpg --batch --verify /usr/local/bin/gosu.asc /usr/local/bin/gosu; \
	gpgconf --kill all; \
	rm -rf "$GNUPGHOME" /usr/local/bin/gosu.asc; \
	apt-mark auto '.*' > /dev/null; \
	[ -z "$savedAptMark" ] || apt-mark manual $savedAptMark > /dev/null; \
	apt-get purge -y --auto-remove -o APT::AutoRemove::RecommendsImportant=false; \
	chmod +x /usr/local/bin/gosu; \
	gosu --version; \
	gosu nobody true

RUN mkdir /docker-entrypoint-initdb.d

RUN apt-get update && apt-get install -y --no-install-recommends \
# for MYSQL_RANDOM_ROOT_PASSWORD
		pwgen \
# for mysql_ssl_rsa_setup
		openssl \
# FATAL ERROR: please install the following Perl modules before executing /usr/local/mysql/scripts/mysql_install_db:
# File::Basename
# File::Copy
# Sys::Hostname
# Data::Dumper
		perl \
# install "xz-utils" for .sql.xz docker-entrypoint-initdb.d files
		xz-utils \
	&& rm -rf /var/lib/apt/lists/*

RUN set -ex; \
# gpg: key 5072E1F5: public key "MySQL Release Engineering <mysql-build@oss.oracle.com>" imported
	key='A4A9406876FCBD3C456770C88C718D3B5072E1F5'; \
	export GNUPGHOME="$(mktemp -d)"; \
	gpg --batch --keyserver ha.pool.sks-keyservers.net --recv-keys "$key"; \
	gpg --batch --export "$key" > /etc/apt/trusted.gpg.d/mysql.gpg; \
	gpgconf --kill all; \
	rm -rf "$GNUPGHOME"; \
	apt-key list > /dev/null

ENV MYSQL_MAJOR 8.0
ENV MYSQL_VERSION 8.0.21-1debian10

RUN echo "deb http://repo.mysql.com/apt/debian/ buster mysql-${MYSQL_MAJOR}" > /etc/apt/sources.list.d/mysql.list

# the "/var/lib/mysql" stuff here is because the mysql-server postinst doesn't have an explicit way to disable the mysql_install_db codepath besides having a database already "configured" (ie, stuff in /var/lib/mysql/mysql)
# also, we set debconf keys to make APT a little quieter
RUN { \
		echo mysql-community-server mysql-community-server/data-dir select ''; \
		echo mysql-community-server mysql-community-server/root-pass password ''; \
		echo mysql-community-server mysql-community-server/re-root-pass password ''; \
		echo mysql-community-server mysql-community-server/remove-test-db select false; \
	} | debconf-set-selections \
	&& apt-get update && apt-get install -y mysql-community-client="${MYSQL_VERSION}" mysql-community-server-core="${MYSQL_VERSION}" && rm -rf /var/lib/apt/lists/* \
	&& rm -rf /var/lib/mysql && mkdir -p /var/lib/mysql /var/run/mysqld \
	&& chown -R mysql:mysql /var/lib/mysql /var/run/mysqld \
# ensure that /var/run/mysqld (used for socket and lock files) is writable regardless of the UID our mysqld instance ends up having at runtime
	&& chmod 777 /var/run/mysqld

VOLUME /var/lib/mysql
# Config files
COPY config/ /etc/mysql/
COPY docker-entrypoint.sh /usr/local/bin/
RUN ln -s usr/local/bin/docker-entrypoint.sh /entrypoint.sh # backwards compat
ENTRYPOINT ["docker-entrypoint.sh"]

EXPOSE 3306 33060
CMD ["mysqld"]