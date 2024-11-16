# Stage 1: Base image for Java setup
FROM buildpack-deps:bookworm AS java-base

# Define Java version and download URLs
ENV JAVA_VERSION=13.46.15 \
    JAVA_UPDATE=13.0.10

ARG TARGETPLATFORM
RUN echo "Downloading JDK for $TARGETPLATFORM" \
    && case "$TARGETPLATFORM" in \
        linux/amd64) ARCHITECTURE='https://cdn.azul.com/zulu/bin/zulu13.46.15-ca-jdk13.0.10-linux_x64.tar.gz' ;; \
        linux/arm64) ARCHITECTURE='https://cdn.azul.com/zulu-embedded/bin/zulu13.46.15-ca-jdk13.0.10-linux_aarch64.tar.gz' ;; \
        *) ARCHITECTURE='https://cdn.azul.com/zulu/bin/zulu13.46.15-ca-jdk13.0.10-linux_x64.tar.gz' ;; \
    esac \
    && curl -fsSL "$ARCHITECTURE" -o /tmp/openjdk13.tar.gz \
    && mkdir -p /usr/local/openjdk13 \
    && tar -xzf /tmp/openjdk13.tar.gz -C /usr/local/openjdk13 --strip-components=1 \
    && rm -f /tmp/openjdk13.tar.gz


# JUnit Platform Console Standalone
RUN set -xe && \
    mkdir /usr/local/junit-platform-console-standalone-1.6.2 && \
    cd /usr/local/junit-platform-console-standalone-1.6.2 && \
    curl -fSsL "https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.6.2/junit-platform-console-standalone-1.6.2.jar" -o launcher.jar

# Add junit related libraries

ADD java-libs   /usr/local/java-libs/

ADD junit-standalone-lib   /usr/local/junit-standalone-lib/

# Stage 2: Base image for Python setup
FROM buildpack-deps:bookworm AS python-base

# Define Python versions to install
ENV PYTHON_VERSIONS="3.8.1 2.7.17" \
    PYTHON_INSTALL_DIR=/usr/local/python
COPY python/python-2.7.17.tar.xz /tmp/python-src/python-2.7.17.tar.xz
COPY python/python-3.8.1.tar.xz /tmp/python-src/python-3.8.1.tar.xz

RUN set -xe && \
    mkdir -p "$PYTHON_INSTALL_DIR" && \
    for VERSION in $PYTHON_VERSIONS; do \
        echo "Installing Python $VERSION..." && \
        mkdir -p /tmp/python-$VERSION && \
        tar -xf /tmp/python-src/python-$VERSION.tar.xz -C /tmp/python-$VERSION --strip-components=1 && \
        rm -f /tmp/python-src/python-$VERSION.tar.xz && \
        cd /tmp/python-$VERSION && \
        ./configure --prefix=$PYTHON_INSTALL_DIR/$VERSION && \
        make -j$(nproc) && \
        make install && \
        rm -rf /tmp/python-$VERSION;\
    done
#TODO: must update the places where the python version is being used :



# JUnit Platform Console Standalone
RUN set -xe && \
    mkdir /usr/local/junit-platform-console-standalone-1.6.2 && \
    cd /usr/local/junit-platform-console-standalone-1.6.2 && \
    curl -fSsL "https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.6.2/junit-platform-console-standalone-1.6.2.jar" -o launcher.jar

# Add junit related libraries

ADD java-libs    /usr/local/java-libs/


FROM buildpack-deps:bookworm AS bash-base
## Check for latest version here: https://ftpmirror.gnu.org/bash
## I was getting the error, while building the docker image for the following task
## 'curl: (56) OpenSSL SSL_read: error:0A000126:SSL routines::unexpected eof while reading, errno 0' was the
## error while connectiong to ftpmirror.gnu.org/bash , so I changed to ftp.gnu.org, and the
## build seems to be working..
ENV BASH_VERSIONS="\
      5.0"
RUN set -xe && \
    for VERSION in $BASH_VERSIONS; do \
      curl -fSsL "https://ftp.gnu.org/gnu/bash/bash-5.0.tar.gz" -o /tmp/bash-$VERSION.tar.gz && \
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
# Stage 3: Final image combining Java and Python
FROM buildpack-deps:bookworm

# Copy Java installation from the Java base stage
COPY --from=java-base /usr/local/openjdk13 /usr/local/openjdk13
COPY --from=java-base /usr/local/java-libs/ /usr/local/java-libs/
COPY --from=java-base /usr/local/junit-standalone-lib/ /usr/local/junit-standalone-lib/

# Copy Python installation from the Python base stage
COPY --from=python-base /usr/local/python /usr/local/python

COPY --from=bash-base  /usr/local/bash-5.0 /usr/local/bash-5.0

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

RUN apt-get update && \
    apt-get install -y --no-install-recommends git libcap-dev && \
    rm -rf /var/lib/apt/lists/* && \
    git clone https://github.com/envicutor/isolate.git /tmp/isolate/ && \
    cd /tmp/isolate && \
    git checkout af6db68042c3aa0ded80787fbb78bc0846ea2114 && \
    make -j$(nproc) install && \
    rm -rf /tmp/*

# Set up environment variables
# WE ARE NOT SETTING ANY ENVIRONMENT VARIABLE

# ENV JAVA_HOME=/usr/local/openjdk13 \
#    PATH="/usr/local/openjdk13/bin:/usr/local/python/3.8.1/bin:/usr/local/python/2.7.17/bin:$PATH"

# Create symbolic links for Java tools,
# We certainly don't want to do this, but
RUN ln -s "$JAVA_HOME/bin/javac" /usr/local/bin/javac \
    && ln -s "$JAVA_HOME/bin/java" /usr/local/bin/java \
    && ln -s "$JAVA_HOME/bin/jar" /usr/local/bin/jar

# Verify installation of Java and Python
#RUN set -xe && \
#    java -version && \
#    for PYTHON_BIN in /usr/local/python/*/bin/python*; do \
#        $PYTHON_BIN --version; \
#    done

ENV BOX_ROOT="/var/local/lib/isolate"

LABEL maintainer="Abhiram misrha"
LABEL version="1.0.0"
