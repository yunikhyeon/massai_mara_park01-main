# 빌드 단계
FROM gradle:8.12-jdk17-alpine AS build

WORKDIR /app

# gradle 캐시를 활용하기 위해 필요한 파일 먼저 복사
COPY build.gradle settings.gradle .
COPY gradle ./gradle
RUN gradle dependencies --no-daemon

# 소스 코드 복사 및 빌드
COPY src ./src
RUN gradle bootJar --no-daemon -x test

# 실행 단계
FROM amazoncorretto:17-alpine

WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

ENV JAVA_OPTS="-Xms512m -Xmx512m"
ENV SERVER_PORT=8080

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar app.jar"]
