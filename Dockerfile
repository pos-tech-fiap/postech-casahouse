# docker build -f Dockerfile -t casahouse-local .
# docker run -p 5432:5432 -v $(pwd):/postech-casahouse/ casahouse-local
FROM postgres:latest

ENV POSTGRES_DB casahouse
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD postgres

COPY init.sql /docker-entrypoint-initdb.d/

EXPOSE 5432