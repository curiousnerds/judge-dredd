# Check for latest version here: https://hub.docker.com/_/buildpack-deps?tab=tags&page=1&name=buster&ordering=last_updated
# This is just a snapshot of buildpack-deps:buster that was last updated on 2019-12-28.

#Abhiram : this is taken from https://github.com/judge0/api-base/blob/v1.2.1/Dockerfile

FROM buildpack-deps:kinetic

ARG TARGETPLATFORM
RUN echo '===========================SETTING UP JAVA FOR '$TARGETPLATFORM'=========================='

# Since the java is being downloaded from a source, its essential to download the specific version meant
#for the targetplatform read https://nielscautaerts.xyz/making-dockerfiles-architecture-independent.html

RUN if [ "$TARGETPLATFORM" = "linux/amd64" ]; then ARCHITECTURE='https://cdn.azul.com/zulu/bin/zulu13.46.15-ca-jdk13.0.10-linux_x64.tar.gz'; elif [ "$TARGETPLATFORM" = "linux/arm64" ]; then ARCHITECTURE='https://cdn.azul.com/zulu-embedded/bin/zulu13.46.15-ca-jdk13.0.10-linux_aarch64.tar.gz'; else ARCHITECTURE='https://cdn.azul.com/zulu/bin/zulu13.46.15-ca-jdk13.0.10-linux_x64.tar.gz'; fi \
    && curl -fSsL   "${ARCHITECTURE}" -o /tmp/openjdk13.tar.gz \
    && mkdir /usr/local/openjdk13  \
    && tar xzf /tmp/openjdk13.tar.gz  -C /usr/local/openjdk13 --strip-components=1 \
    && ln -s /usr/local/openjdk13/bin/javac /usr/local/bin/javac  \
    && ln -s /usr/local/openjdk13/bin/java /usr/local/bin/java  \
    && ln -s /usr/local/openjdk13/bin/jar /usr/local/bin/jar

# Check for latest version here: https://jdk.java.net, and version 13 can be downloaded from https://download.java.net/java/GA/jdk13.0.1/cec27d702aa74d5a8630c65ae61e4305/9/GPL/openjdk-13.0.1_linux-x64_bin.tar.gz


# JUnit Platform Console Standalone
RUN set -xe && \
    mkdir /usr/local/junit-platform-console-standalone-1.6.2 && \
    cd /usr/local/junit-platform-console-standalone-1.6.2 && \
    curl -fSsL "https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.6.2/junit-platform-console-standalone-1.6.2.jar" -o launcher.jar

# Add junit related libraries

ADD java-libs    /usr/local/java-libs/

## Check for latest version here: https://ftpmirror.gnu.org/bash
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

## Check for latest version here: https://packages.debian.org/buster/sqlite3
## Used for support of SQLite.
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

#Adding python version

# Check for latest version here: https://www.python.org/downloads
ENV PYTHON_VERSIONS \
      3.8.1 \
      2.7.17
RUN set -xe && \
    for VERSION in $PYTHON_VERSIONS; do \
      curl -fSsL "https://www.python.org/ftp/python/$VERSION/Python-$VERSION.tar.xz" -o /tmp/python-$VERSION.tar.xz && \
      mkdir /tmp/python-$VERSION && \
      tar -xf /tmp/python-$VERSION.tar.xz -C /tmp/python-$VERSION --strip-components=1 && \
      rm /tmp/python-$VERSION.tar.xz && \
      cd /tmp/python-$VERSION && \
      ./configure \
        --prefix=/usr/local/python-$VERSION && \
      make -j$(nproc) && \
      make -j$(nproc) install && \
      rm -rf /tmp/*; \
    done

# python addition done.

ENV BOX_ROOT /var/local/lib/isolate

LABEL maintainer="Abhiram misrha"
LABEL version="1.0.0"
