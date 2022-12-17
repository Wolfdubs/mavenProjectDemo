package org.wolf;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}


/*
Project management tool;
    project is not attached to a specific IDE, but is an actual Maven project. Is IDE agnostic
    Java project is not a concept in Java itself; is just the collection of;
        src classes, test cases, resources, libraries & dependencies, project structure, configuration, task runner (build, test, run), reporting
    Maven can manage all of these aspects, rather than relying on the IDE
        it takes all the assorted components and groups into a project, using POM, and can package code into jar and deploy onto web server
Build tool - building, documenting, managing projects
    1. generates source code
    2. generates documentation from src
    3. compiles the src
    5. packages the compilation into jar files
    6. Installs the packaged code into local repo, server or central repo
Based on Project Object Model POM.xml
    XML file containing the project & configuration details
    During task execution, Maven searches for POM in current directory
    Helps for automatically downloading dependencies (jar files) & avoid conflicts between versions
    Ensures correct project structure for servlets & struts
    Builds & deploys the project
    POM file components: dependencies, plugins, life cycles, build profiles
Setup:
    Install
        1. Download binary zip from maven.org
        2. Setup env variables for MVN_HOME and path
        3. Test in cmd: mvn -version
    Utilize
        4. Create 'new maven project'
        5. select the archetype for your project what type of java project it will be;
            maven-archetype-quickstart = core java app
            maven-archetype-webapp = for java web apps
        6. Use plugins to extend Maven functionality

For dependencies, Maven first checks if available locally, if not Maven will download from the central mvn repo
    and stores locally in .m2 folder
GroupID = the globally unique project domain
ArtifactID = project name
Package = GroupID + ArtifactID

Gradle is an alternative to Maven

It compiles files, tests applications and downloads required libraries
 */


/*
Structure: src/main/java = contains all java source code inside package domain
                resources folder = contains files e.g. application.properties, static files, images, text files, html & css & js files, xml files
                    these are not compiled
            src/test/java = contains all test code
            target = when mvn runs the project, it copies the classes and tests into the orange 'target' folder
            POM.xml = contains maven project config
            Effective POM.xml (find by going to Maven sidebar, right click project, select 'Show Effective POM'. This contains full config for the project
      Maven project can consist of sub-modules
        parent project root will have the POM -> specify submodules within <modules><module>ModuleName</module></modules>
        when you build the parent, it will build all the specified modules too
        submodules have their own POM as well
        submodules can be interdependent, so specify each other as a dependency



<build> tags are where you can specify plugins and configure how the project should be built
<scope> means you only need the dependencies e.g. for test directory
alt insert -> use inside POM and will open a maven central repo search for libraries inside the IDE
everything maven ever downloads is stored inside .m2/repository
    test folder can have resources folder too
//got settings.xml file here https://stackoverflow.com/questions/53562194/error-executing-maven-non-parseable-settings-settings-xml
Commands:
    Below commands all stack on top of each other e.g. mvn package will actuall run mvn clean, then mvn compile, then mvn test, then package
    mvn clean: deletes the target folder
    mvn compile: maven checks all the classes inside your src (not test), and compiles them inside target
    mvn test: compiles the src classes, then runs the tests you have in test folder and generates a report
    (if a command fails, run it with .\)
    mvn package: compiles classes and tests them, then puts your src into a jar file inside target, which you can export
    mvn install: adds that jar file to your local mvn repo (afters it implicitly calls mvn package to run to generate a jar from your src)

 */

/*
Transitive dependencies = if a dependency requires other dependencies, Maven will auto download those too
    <exclusion> used to specify required dependencies not to download, because you want to use the one you specified yourself in <dependency>
Dependency types:
    SNAPSHOT = under development, unstable
    RELEASE = released deployment, stable
<scope> 5 types;
    compile = default, available only at compile time inside classpath
    provided = provided by JDK or runtime (e.g. web server). e.g. for servlet.
    runtime = available only at runtime, not compile time. e.g. for mySQL
    test = available only when writing and running tests
    system = like provided, by specify where to find dependency in the system
Maven stores libraries in .m2/repository, after downloading from remote repo

Build Lifecycle:
    Default
        Below commands are all inclusive of the earlier ones, e.g. mvn deploy will execute from validate through to deploy
        validate = validates pom.xml
        compile = compiles src
        test = runs written unit tests
        package = packages src into artifact e.g. jar
        integration-test = integration tests (if you have any)
        verify = verify results of integrations tests
        install = install created artifact locally
        deploy = deploys the artifact to remote repository
            configured in pom.xml under <distributionManagement>. In reality it would be link to Nexus
    Clean - cleans compiled java and generated metadata
        e.g. mvn clean install will delete the compiled classes, then runs the install command to run the default commands up to generating an artifact
    Site - generates the java documentation in project

Maven Plugins
    used to execute the commands for the build lifecycle
    defined under <build><plugin>
        in the effective-pom.xml
    surefire plugin used to run Maven tests
    can specify what java version to use for commands defined in <plugin>

Modules
    Can define parent POM that is inherited by all child modules
    child modules are auto added to parent modules pom
    child module pom will also specify what its parent it
    to share dependencies in the parent pom with all child modules, surround <dependencies> list with <dependencyManagement>
    manage shared plugins same way with <pluginManagement> as a surrounding tag around <plugins>
 */