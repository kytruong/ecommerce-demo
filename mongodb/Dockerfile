FROM mvertes/alpine-mongo

# Modify child mongo to use /data/db2 as dbpath (because /data/db wont persist the build)
RUN mkdir -p /data/db2 \
    && echo "dbpath = /data/db2" > /etc/mongodb.conf \
    && chown -R mongodb:mongodb /data/db2

COPY . /data/db2

RUN mongod --fork --logpath /var/log/mongodb.log --dbpath /data/db2 --smallfiles \
    && CREATE_FILES_AUDITTRAIL=/data/db2/scripts/audittrails/*-create.js \
    && for f in $CREATE_FILES_AUDITTRAIL; do mongo 127.0.0.1:27017/audittrails $f; done \
    && CREATE_FILES_PRODUCT=/data/db2/scripts/products/*-create.js \
    && for f in $CREATE_FILES_PRODUCT; do mongo 127.0.0.1:27017/products $f; done \
    && INSERT_FILES_PRODUCT=/data/db2/scripts/products/*-insert.js \
    && for f in $INSERT_FILES_PRODUCT; do mongo 127.0.0.1:27017/products $f; done \
    && mongod --dbpath /data/db2 --shutdown \
    && chown -R mongodb /data/db2

# Make the new dir a VOLUME to persists it
VOLUME /data/db2

CMD ["mongod", "--config", "/etc/mongodb.conf", "--smallfiles", "--bind_ip_all"]
