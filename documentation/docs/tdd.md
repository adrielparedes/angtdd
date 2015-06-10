
![image](images/redhat.png)

# Agile Application Development

<!-- TOC depth:6 withLinks:1 updateOnSave:1 -->
- [Agile Application Development](#agile-application-development)
	- [TDD](#tdd)
		- [Prólogo](#prlogo)
		- [Definición](#definicin)
		- [Ciclo de Vida](#ciclo-de-vida)
		- [Creación de Proyecto con JBoss Forge](#creacin-de-proyecto-con-jboss-forge)
			- [Comandos](#comandos)
		- [Ejercitación](#ejercitacin)
			- [Requerimientos](#requerimientos)
		- [Test Coverage](#test-coverage)
	- [Mockito](#mockito)
		- [¿Qué es Mockito?](#qu-es-mockito)
		- [¿Porque uso mockito?](#porque-uso-mockito)
		- [Ejercitación](#ejercitacin)
	- [JEE (JAXRS, CDI, JPA)](#jee-jaxrs-cdi-jpa)
		- [Definiciones](#definiciones)
	- [Testing JEE (Arquillian, Shrinkwrap, JPA)](#testing-jee-arquillian-shrinkwrap-jpa)
		- [Teoría](#teora)
		- [Ejercitación](#ejercitacin)
	- [Cloud](#cloud)
		- [Conclusión](#conclusin)
		- [Adicionales](#adicionales)
	- [Integración Contínua](#integracin-contnua)
	- [BDD (Cucumber)](#bdd-cucumber)
		- [¿Qué es Behaviour Driven Developement?](#qu-es-behaviour-driven-developement)
		- [Ejercitation](#ejercitation)
	- [Arquillian Graphene y Arquillian Drone (No se va a usar porque todo se hace con KARMA, PROTRACTOR y](#arquillian-graphene-y-arquillian-drone-no-se-va-a-usar-porque-todo-se-hace-con-karma-protractor-y)
	- [Intro AngularJS](#intro-angularjs)
	- [Requerimientos](#requerimientos)
	- [Bootstrap del proyecto](#bootstrap-del-proyecto)
	- [Views](#views)
	- [Controllers](#controllers)
		- [Scope](#scope)
		- [Bingings](#bingings)
	- [Services](#services)
		- [Factory](#factory)
		- [Service](#service)
		- [Provider](#provider)
	- [Manejo de Errores (toastr)](#manejo-de-errores-toastr)
	- [Directives](#directives)
	- [Testing](#testing)
		- [Jasmine](#jasmine)
		- [Protractor](#protractor)
		- [Karma](#karma)
<!-- /TOC -->

## TDD


### Prólogo

TDD no se trata de reglas a seguir, se trata de generar el hábito, en este texto se van a explicar ciertos conceptos, pero van a ver que no existe ningun receta a seguir, sino consejos para poder cumplir ese objetivo.  ¿Hay una única manera? No, y eso es lo que quiero transmitir.

### Definición

TDD es una técnica muy simple que tiene dos pilares importantes: primero escribir el **Test** y luego **Refactoring**. La gracia es que primero antes que nada tengo que escribir "**¿Qué es lo que quiero?**" en un test de unidad, y lo pruebo, verifico que falla, lo arreglo y vuelvo a comenzar.
Esto es importante porque me permite concentrarme primero en el **QUÉ** y luego me preocupo por el **CÓMO**.
Esta simple premisa me permite escribir código mucho más descriptivo, porque antes de escribri una sola línea ya entiendo bien el requerimiento funcional. Además me permite mejorar la calidad de mi aplicación ya que al poder probar cada sección todo el tiempo, realizar un cambio de la misma puede verificar que el comportamiento modificado no afecta al resto de la aplicación. Otra ventaja es una mejor distribución de la responsabilidad de las partes involucradas, lo que decanta como una mejora en la cohesión y la disminución en el acoplamiento de los componentes.

**Nota:** TDD no es lo mismo que un Unit Test.

### Ciclo de Vida

1. **Elegir un requerimiento:** Elegir el caso de uso, User Story, definición funcional que se desea implementar.
2. **Hacer un test:** Hacer el test que define el requerimiento.
3. **Verificar que falla:** El test seguramente no tenga código implementado, por lo que la primera implementación va a fallar.
4. **Arreglar el test:** Implementar el comportamiento para que el test pase.
5. **Volver a ejecutar los tests:** Volver a ejecutar los tests para comprobar que el comportamiento implementado resuelve el requerimiento y no destruya al resto.
6. **Eliminar la redundancia:** Etapa donde se itenta eliminar el código duplicado. Luego se vuelven a ejecutar los tests.
7. **Volver a empezar:** Todo vuelve a comenzar, con lo cual vuelvo al primer paso.

![image](images/TDD-Diagram.gif)

### Creación de Proyecto con JBoss Forge

JBoss Forge es una herramienta para facilitar la construcción de ciertos artefactos dentro de nuestro desarrollo. Basada en la idea de los generadores de Ruby on Rails.

La herramienta nos va a permitir automatizar la creación de los proyectos, clases, entidad de persistencia, EJBs, Test, etc. Es una herramienta muy poderosa en la cual se puede escribir sus propios addons para realizar tareas propias de la organizacion.

Tambien se puede utilizar para realizar _"Scaffolding"_ para las interafes web, pero no veremos este proceso, sino que nos vamos a concentrar en las bases en caso de no contar con la herramienta. Es preferible dejar la _magia_ para otro momento y ver el proceso completo.

**Webpage:** http://forge.jboss.org/

#### Comandos

```bash
$> forge
[avianca] project-new \
	--named backend \
	--topLevelPackage com.redhat.backend \
	--finalName backend \
	--version 1.0.0.Final
```

****
### Ejercitación

#### Requerimientos

Basado en la cantidad de pasajeron que desean comprar un boleto, buscar entre todos los asientos las mejores ubicaciones:

* Un avión tiene secciones.
* Cada sección tiene asientos.
* Cada asiento puede ser reclinable o no.
* Cada asiento sabe si esta ocupado o no.
* Cada asiento sabe si es medio,ventana,pasillo.
* Cada asiento tiene un identificador. (A1, B2, etc)
* Cada asiento conoce a los 4 asientos a su alrededor.
* El mejor asiento disponible el que que no posee otro asiento delante de el.
* Luego si estan junto a una ventana o junto al pasillo.
* El peor asiento es el que no se puede reclinar. Esta condición predomina por sobre el resto.
* No se tendrán en cuenta las puertas o salidas de emergencia.

----

Generar diferentes criterios de busqueda para poder encontrar los asientos que quiero. Esto es para los usuarios, diferente del algoritmo de busqueda del mejor asiento:

* Filtrar por Asientos de ventana
* Filtrar por Asientos de pasillo
* Filtrar por Asientos

----

Una vez que se acepta la compra de los boletos, necesito imprimir el bording pass. Para ello tengo que tomar un `String` y reemplazarlo por los datos de las personas que compraron los tickets.

----

### Test Coverage


El test coverage es una métrica muy interesante a la hora de entender la capacidad que tiene nuestra aplicación de sufrir cambios sin correr el riesgo de no saber cuales son las partes que pueden afectar. Un el porcentaje _coverage_ indica la cantidad de código fuente que se esta probando. Mientras mas alto mejor. ¿Es importante tener un 100% de cobertura? No, porque hay cosas que no tienen sentido probar, como por ejemplo los _accessors_. Sin embargo tenemos que preocuparnos por mantener el porcentaje alto. Una covertura mayor al 80% es una excelente noticia.

Para poder medir la covertura hay varios plugins que se pueden instalar. En este caso vamos a recomendar el link que se encuentra debajo. Se instla sobre el JBoss Developer Studio, y funciona perfectamente. Al ejecutar los tests desde el eclipse, aparece una opción para utilizar este plugin y medir la covertura.

[http://www.eclemma.org/](http://www.eclemma.org/)

----

![image](images/asientos.jpg)

## Mockito

* [http://mockito.org/](http://mockito.org/)
* [http://site.mockito.org/mockito/docs/current/org/mockito/Mockito.html](http://site.mockito.org/mockito/docs/current/org/mockito/Mockito.html)

### ¿Qué es Mockito?

Mockito es un framework de **mocking**. Permite simular objetos, y otorgarle el comportamiento que necesitemos en ese momento.

### ¿Porque uso mockito?

En sistemas complejos, es probable que las interacciones entre los componentes tambien sea compleja. Siempre voy a tener interacciones con bases de datos, servicios externos, colas de mensajería, etc. Sin embargo en los tests de unidad no me interesa probar esto, porque como la palabra lo dice, intento de probar solo pequeñas partes, y no me interesa la interacción que tienen las mismas.

* **Stubbing:** Es un fragmento de comportamiento que simula la ejecución del método invocado.

```java
LinkedList mockedList = mock(LinkedList.class);

when(mockedList.get(0)).thenReturn("first");

System.out.println(mockedList.get(0));

System.out.println(mockedList.get(999));
```

* **Verification:** Poder escribir de una forma fácil y descriptiva la aceptación del resultado final.

```java
List mockedList = mock(List.class);

mockedList.add("one");
mockedList.clear();

verify(mockedList).add("one");
verify(mockedList).clear();
```

* **Matchers:** Sentencias que me permiten escribir declarativamente la combinación entre los elementos

```java
when(mockedList.get(anyInt())).thenReturn("element");

when(mockedList.contains(argThat(isValid()))).thenReturn("element");

System.out.println(mockedList.get(999));

verify(mockedList).get(anyInt());
```

* **Exceptions:** Puedo manejar, crear y lanzar excepciones

```java
when(mock.someMethod("some arg"))
 .thenThrow(new RuntimeException(), new NullPointerException());
```

```java
doThrow(new RuntimeException()).when(mockedList).clear();

mockedList.clear();
```

* **Callbacks:** A diferencia de un Stubbing, me permite crear metodos más complejos que realizen varias tareas.

```java
when(mock.someMethod(anyString())).thenAnswer(new Answer() {

	    Object answer(InvocationOnMock invocation) {

	    Object[] args = invocation.getArguments();

	    Object mock = invocation.getMock();

	    return "called with arguments: " + args;

    }

});

```

### Ejercitación

Armar los repositorios de la aplicación y armar los tests de prueba de esos repositorios.


## JEE (JAXRS, CDI, JPA)

Pequeño repaso por los estandares de JEE, de donde salen, quien los implementa, etc. Esto nos abre la puerta para el Testing sobre JEE.

### Definiciones

**CDI | Context and Dependency Injection:** Es el mecanismo estandar (JSR-299) encargado de resolver las dependencias dentro de un contenedor JEE. Implementado a partir de la version 6 del estandar.

**JAXRS | REST Services Standar:** Estandar encargado de regular la implementación de servicios REST dentro de un contenedor JEE.

**JPA | Java Persistence API:** Regula el comportamiento que debería implementar un framework de persistencia dentro del estandar JEE.


#### CDI Declaration

Agregar el **beans.xml**

```xml
<?xml version="1.0"?>
<beans xmlns="http://java.sun.com/xml/ns/javaee"
 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://jboss.org/schema/cdi/beans_1_0.xsd">
</beans>
```

#### Persistence Declaration (persistence.xml)

```xml
<persistence xmlns="http://java.sun.com/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd"
             version="2.0">
    <persistence-unit name="tickets"  transaction-type="JTA">
			<provider>org.hibernate.ejb.HibernatePersistence</provider>
			<jta-data-source>java:/Postgresql</jta-data-source>

      <class>my.package.MyClass</class>
			<properties>
				<property name="hibernate.hbm2ddl.auto" value="update" />
				<property name="hibernate.show_sql" value="false" />
				<property name="hibernate.format_sql" value="true" />
				<property name="hibernate.dialect" value="org.hibernate.dialect.PostgreSQLDialect"/>
			</properties>

    </persistence-unit>
</persistence>
```

```java
@PersistenceContext
private EntityManager entityManager;
```

## Testing JEE (Arquillian, Shrinkwrap, JPA)

### Teoría

¿Qué es Arquillian?

La propia definición de su web dice:

>Arquillian is an innovative and highly extensible testing platform for the JVM that enables developers to easily create automated integration, functional and acceptance tests for Java middleware.

Arquillian nos permite armar tests donde se necesita un contenedor JEE. Y como bien lo dice, no es para hacer test de unidad, sino para probar cierta integración. Probar componentes que trabajan en conjunto, como por ejemplo un servicio rest expuesto, un bean injectado, una base de datos, etc, etc.
Este punto es muy interesante porque a diferencia de los test de unidad yo necesito probar algo mas complejo, una interacción. No hay que caer en la tentación de querer probar todo con arquillian. Es más, si todos mis tests usan arquillian, de algun modo significa que mi aplicación tiene un alto acomplamiento, y esto puede ser contraproducente para la calidad, y la posibilidad de cambio.

[http://arquillian.org/](http://arquillian.org/)

[https://github.com/arquillian/arquillian-showcase](https://github.com/arquillian/arquillian-showcase)

### Ejercitación

Probar los rest, testear con arquillian.
Tal vez probar la base de datos con una postgres alternativa.


## Cloud

El testing cloud es algo muy particular. La nube es un nuevo concepto, el cual podemos aprovechar para cosas diversas, siempre y cuando me lo permita. Para esta item vamos a analizar Openshift, el cual nos va a permitir crear un espacio donde albergar nuestras aplicaciones.

1. Primero debemos abrirnos una cuenta en www.openshift.com
2. Al crearnos la cuenta nos aparecera una menu de administración para crear aplicaciones.
3. Allí buscaremos **Enterprise Application Platform 6**, y le asignamos el nombre **test**
4. No debemos olvidar las credenciales porque los vamos a usar después, en especial la larga cadena de caracteres que representa un usuario virtual dentro de Openshift.


```
mvn test -Parquillian-openshift-express -Darquillian.launch=openshift-express
```

### Conclusión

Lo interesante de esto es que Arquillian nos permite utilizar cualquier tipo de contendor para hacer el despliegue. Openshift nos da la facilidad de exponer el contenedor, lo que nos permite poder utilizarlo como ejecutor de los tests.

### Adicionales

[http://arquillian.org/guides/testing_in_the_cloud/](http://arquillian.org/guides/testing_in_the_cloud/)


```xml
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
								<arquillian.launch>jbossas_managed</arquillian.launch>
							</systemPropertyVariables>
						</configuration>
					</plugin>

				</plugins>
			</build>


</profile>
```



```xml


<?xml version="1.0"?>
<arquillian xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns="http://jboss.org/schema/arquillian"
    xsi:schemaLocation="http://jboss.org/schema/arquillian http://www.jboss.org/schema/arquillian/arquillian_1_0.xsd">


		<defaultProtocol type="Servlet 3.0" />
		<container qualifier="openshift-express">
		    <configuration>
		        <property name="namespace">ikecloud</property>
		        <property name="application">test</property>
		        <property name="sshUserName">4348a6ba9d3943e6a64e0a1607b37bd5</property>
		        <property name="passphrase">Password</property>
		        <property name="login">foobar@example.com</property>
		    </configuration>
		</container>

</arquillian>


```

## Integración Contínua

Por definición:
>La integración continua (continuous integration en inglés) es un modelo informático propuesto inicialmente por Martin Fowler que consiste en hacer integraciones automáticas de un proyecto lo más a menudo posible para así poder detectar fallos cuanto antes. Entendemos por integración la compilación y ejecución de pruebas de todo un proyecto.

[https://jenkins-ci.org/](https://jenkins-ci.org/)
[https://docs.jboss.org/author/display/ARQ/Container+config+runtime+selection](https://docs.jboss.org/author/display/ARQ/Container+config+runtime+selection)

### Ejercitación

En este punto vamos a configurar nuestra aplicación para que pueda correr sobre Openshift. Agregamos los testes necesarios y hacemos el push de la aplicación. Al hacer eso, se va a disparar el _job_ de Jenkins que va a construir y ejecutar los tests sobre el application server creado en el ejercicio anterior.

### Adicionales

#### Maven

```xml

<dependencyManagement>
	<dependencies>
		<!-- JBoss distributes a complete set of Java EE 6 APIs including a Bill
			of Materials (BOM). A BOM specifies the versions of a "stack" (or a collection)
			of artifacts. We use this here so that we always get the correct versions
			of artifacts. Here we use the jboss-javaee-6.0-with-tools stack (you can
			read this as the JBoss stack of the Java EE 6 APIs, with some extras tools
			for your project, such as Arquillian for testing) and the jboss-javaee-6.0-with-hibernate
			stack you can read this as the JBoss stack of the Java EE 6 APIs, with extras
			from the Hibernate family of projects) -->
		<dependency>
			<groupId>org.jboss.bom</groupId>
			<artifactId>jboss-javaee-6.0-with-resteasy</artifactId>
			<version>${version.jboss.bom}</version>
			<type>pom</type>
			<scope>import</scope>
		</dependency>
		<dependency>
			<groupId>org.jboss.bom</groupId>
			<artifactId>jboss-javaee-6.0-with-tools</artifactId>
			<version>${version.jboss.bom}</version>
			<type>pom</type>
			<scope>import</scope>
		</dependency>
		<dependency>
			<groupId>org.jboss.bom</groupId>
			<artifactId>jboss-javaee-6.0-with-hibernate</artifactId>
			<version>${version.jboss.bom}</version>
			<type>pom</type>
			<scope>import</scope>
		</dependency>
	</dependencies>
</dependencyManagement>

<dependencies>
	<!-- Import the CDI API, we use provided scope as the API is included in
		JBoss AS 7 -->
	<dependency>
		<groupId>javax.enterprise</groupId>
		<artifactId>cdi-api</artifactId>
		<scope>provided</scope>
	</dependency>

	<!-- Import the Common Annotations API (JSR-250), we use provided scope
		as the API is included in JBoss AS 7 -->
	<dependency>
		<groupId>org.jboss.spec.javax.annotation</groupId>
		<artifactId>jboss-annotations-api_1.1_spec</artifactId>
		<scope>provided</scope>
	</dependency>

	<!-- Import the JAX-RS API, we use provided scope as the API is included
		in JBoss AS 7 -->
	<dependency>
		<groupId>org.jboss.spec.javax.ws.rs</groupId>
		<artifactId>jboss-jaxrs-api_1.1_spec</artifactId>
		<scope>provided</scope>
	</dependency>

	<!-- Import the JPA API, we use provided scope as the API is included in
		JBoss AS 7 -->
	<dependency>
		<groupId>org.hibernate.javax.persistence</groupId>
		<artifactId>hibernate-jpa-2.0-api</artifactId>
		<scope>provided</scope>
	</dependency>

	<!-- Import the EJB API, we use provided scope as the API is included in
		JBoss AS 7 -->
	<dependency>
		<groupId>org.jboss.spec.javax.ejb</groupId>
		<artifactId>jboss-ejb-api_3.1_spec</artifactId>
		<scope>provided</scope>
	</dependency>
</dependencies>

<profile>
	<!-- An optional Arquillian testing profile that executes tests in your
		JBoss AS instance -->
	<!-- This profile will start a new JBoss AS instance, and execute the
		test, shutting it down when done -->
	<!-- Run with: mvn clean test -Parq-jbossas-managed -->
	<id>arq-jbossas-managed</id>
	<dependencies>
		<dependency>
			<groupId>org.jboss.as</groupId>
			<artifactId>jboss-as-arquillian-container-managed</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>
</profile>

<profile>
	<!-- An optional Arquillian testing profile that executes tests in a remote
		JBoss AS instance -->
	<!-- Run with: mvn clean test -Parq-jbossas-remote -->
	<id>arq-jbossas-remote</id>
	<dependencies>
		<dependency>
			<groupId>org.jboss.as</groupId>
			<artifactId>jboss-as-arquillian-container-remote</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>
</profile>


<profile>
	<!-- When built in OpenShift the 'openshift' profile will be used when
		invoking mvn. -->
	<!-- Use this profile for any OpenShift specific customization your app
		will need. -->
	<!-- By default that is to put the resulting archive into the 'deployments'
		folder. -->
	<!-- http://maven.apache.org/guides/mini/guide-building-for-different-environments.html -->
	<id>openshift</id>

	<properties>
		<dynabox.environment>OPENSHIFT</dynabox.environment>
	</properties>

	<dependencies>
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
				<artifactId>maven-war-plugin</artifactId>
				<version>${version.war.plugin}</version>
				<configuration>
					<outputDirectory>deployments</outputDirectory>
					<warName>ROOT</warName>
					<packagingExcludes>**/jboss-web.xml</packagingExcludes>
					<webResources>
						<resource>
							<directory>src/main/webapp</directory>
							<filtering>true</filtering>
							<includes>
								<include>dynabox.version</include>
							</includes>
						</resource>

					</webResources>

				</configuration>
			</plugin>
		</plugins>
	</build>
</profile>


<repositories>
	<repository>
		<id>Red Hat Repository</id>
		<url>http://maven.repository.redhat.com/techpreview/all/</url>
	</repository>
</repositories>
```

## BDD (Cucumber)

[https://cukes.info/](https://cukes.info/)
[https://cukes.info/docs/reference](https://cukes.info/docs/reference)


### ¿Qué es Behaviour Driven Developement?

BDD es una evolución de las técnicas de **TDD** y **Domain Driven Design**. Intenta mezclar las técnicas declarativas de TDD y el diseño de tests orientadas al negocio. Existen muchos frameworks para poder realizar _"tests BDD"_, lo que no significa que este oblidado a hacer. Sin embargo ayudar y facilitan el entendimiento del dominio primero sin preocuparnos por como lo vamos a implementar (esta es la evolución por sobre TDD).


### Ejercitation

Tomar un test de unidad escribo mediante la técnica de TDD y representarla en BDD.

### Adicionales

#### Maven
```xml
<dependency>
    <groupId>info.cukes</groupId>
    <artifactId>cucumber-java</artifactId>
    <version>1.2.2</version>
    <scope>test</scope>
</dependency>

<dependency>
    <groupId>info.cukes</groupId>
    <artifactId>cucumber-junit</artifactId>
    <version>1.2.2</version>
    <scope>test</scope>
</dependency>
```
#### Junit
```java
package mypackage;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class RunCukesTest {
}
```

#### Feature

```gherkin
Feature: Refund item

  Scenario: Jeff returns a faulty microwave
    Given Jeff has bought a microwave for $100
    And he has a receipt
    When he returns the microwave
    Then Jeff should be refunded $100
```

#### Step
```java
public class Stepdefs {
    @Given("I have (\\d+) cukes in my belly")
    public void I_have_cukes_in_my_belly(int cukes) {
        System.out.format("Cukes: %n\n", cukes);
    }
}
```

## Arquillian Graphene y Arquillian Drone

[http://arquillian.org/guides/functional_testing_using_graphene/](http://arquillian.org/guides/functional_testing_using_graphene/)
