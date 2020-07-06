FROM mariadb

# when mounted to docker-entrypoint-initdb.d, all SQL files in the host folder mariadb/sql will be executed in alphabetical order
ADD sql/ /docker-entrypoint-initdb.d
