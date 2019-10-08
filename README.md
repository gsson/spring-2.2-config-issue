Repository containing a reproducer for spring-projects/spring-boot#18542

_Update_: While initially surprising it works as intended. Latest commit contains the smallest change that restores the
behavior I was after.

See these links for information and discussion:
* [spring-projects/spring-boot#18517](//github.com/spring-projects/spring-boot/issues/18517)
* [spring-projects/spring-boot#18469](//github.com/spring-projects/spring-boot/issues/18469)

---

Manage Spring Boot version in `gradle.properties`

Build with `./gradlew build`
Run with `java -jar build/libs/config-issue-1.0-SNAPSHOT.jar`

With `springBootVersion = 2.2.0.RC1` the application fail to start with the message:

```
$ java -jar build/libs/config-issue-1.0-SNAPSHOT.jar

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::            (v2.2.0.RC1)

---8<---
***************************
APPLICATION FAILED TO START
***************************

Description:

Parameter 0 of constructor in se.fnord.configissue.ApplicationConfiguration required a bean of type 'java.lang.String' that could not be found.


Action:

Consider defining a bean of type 'java.lang.String' in your configuration.

```

With `springBootVersion = 2.2.0.M6` the application starts successfully and serves the expected response.
