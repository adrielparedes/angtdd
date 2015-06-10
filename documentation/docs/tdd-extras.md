```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app version="3.0" xmlns="http://java.sun.com/xml/ns/javaee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd">

</web-app>
```


```xml
<?xml version="1.0" encoding="UTF-8"?>
<project
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd"
	xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.redhat.cursos</groupId>
	<artifactId>tdd.tickets</artifactId>
	<version>1.0.0.Final</version>
	<packaging>war</packaging>
	<properties>
		<maven.compiler.source>1.7</maven.compiler.source>
		<maven.compiler.target>1.7</maven.compiler.target>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
	</properties>


	<dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>org.jboss.arquillian</groupId>
				<artifactId>arquillian-bom</artifactId>
				<version>1.1.8.Final</version>
				<scope>import</scope>
				<type>pom</type>
			</dependency>
		</dependencies>
	</dependencyManagement>


	<dependencies>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.11</version>
		</dependency>
		<dependency>
			<groupId>org.jboss.arquillian.junit</groupId>
			<artifactId>arquillian-junit-container</artifactId>
			<scope>test</scope>
		</dependency>
    <dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-all</artifactId>
    <version>2.0.2-beta</version>
</dependency>
	</dependencies>


	<profiles>
		<profile>
			<id>arquillian-openshift-express</id>


			<dependencies>
				<dependency>
					<groupId>org.jboss.spec</groupId>
					<artifactId>jboss-javaee-6.0</artifactId>
					<version>1.0.0.Final</version>
					<type>pom</type>
					<scope>provided</scope>
				</dependency>



				<dependency>
					<groupId>org.jboss.arquillian.container</groupId>
					<artifactId>arquillian-openshift-express</artifactId>
					<version>1.0.0.Beta1</version>
					<scope>test</scope>
				</dependency>
			</dependencies>

			<build>
				<plugins>
					<plugin>
						<groupId>org.apache.maven.plugins</groupId>
						<artifactId>maven-surefire-plugin</artifactId>
						<configuration>
							<systemPropertyVariables>
								<arquillian.launch>openshift</arquillian.launch>
							</systemPropertyVariables>
						</configuration>
					</plugin>

				</plugins>


			</build>



		</profile>
	</profiles>

	<build>
		<finalName>backend</finalName>
		<plugins>
			<plugin>
				<artifactId>maven-war-plugin</artifactId>
				<version>2.4</version>
				<configuration>
					<failOnMissingWebXml>false</failOnMissingWebXml>
				</configuration>
			</plugin>
		</plugins>


	</build>


	<repositories>
		<repository>
			<id>Red Hat Repository</id>
			<url>http://maven.repository.redhat.com/techpreview/all/</url>
		</repository>
	</repositories>


</project>



















<dependency>
<groupId>org.jboss.arquillian.protocol</groupId>
<artifactId>arquillian-protocol-servlet</artifactId>
<version>1.1.8.Final</version>
<scope>test</scope>
</dependency>

```
