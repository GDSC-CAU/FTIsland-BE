## docker MariaDB 연결

- [FTIsland-DB](https://github.com/RumosZin/FTIsland-DB) 레포지토리를 clone 받는다.
- FTisland-DB 경로로 이동한 후, 빌드 스크립트를 실행한다.

```shell
$ cd ~/FTIsland-DB/
$ sh ./build.sh
```

- 데이터베이스 컨테이너 실행을 확인한다.
```shell
$ docker ps
CONTAINER ID   IMAGE               COMMAND                  CREATED      STATUS             PORTS                    NAMES
************   mariadb:lts-jammy   "docker-entrypoint.s…"   5 days ago   Up About an hour   0.0.0.0:3308->3306/tcp   ftisland-db
```

## seed data 삽입

- 최초 삽입 시, BeApplication을 실행하면 자동으로 seed data가 삽입된다.
- 이후 BeApplication을 실행할 때, `application.yml`의 `spring.sql.init.mode=never`로 변경한다.