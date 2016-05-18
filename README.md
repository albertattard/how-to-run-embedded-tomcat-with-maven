Java web application require a web container, such as Tomcat (<a href="http://tomcat.apache.org/" target="_blank">homepage</a>), on which these can run.  Installing and configure a web container on each developing machine may be time consuming.  Furthermore, other developers need to manage the dependencies manually if they want to run the web application.


Maven has a tomcat plugin that allows us to run an embedded tomcat instance without the need of installing a local tomcat server.


<pre>
&lt;plugin&gt;
  &lt;groupId&gt;org.apache.tomcat.maven&lt;/groupId&gt;
  &lt;artifactId&gt;tomcat7-maven-plugin&lt;/artifactId&gt;
  &lt;version&gt;2.2&lt;/version&gt;
&lt;/plugin&gt;
</pre>


Please note that this example makes use version 7 of Tomcat.  Please update where necessary if using another version of Tomcat.


Most of the examples will not contain the whole code and may omit fragments which are not relevant to the example being discussed. The readers can download or view all code from the above link.


Include the Tomcat Maven Plugin as shown in the following POM example.


<pre>
&lt;project xmlns="http://maven.apache.org/POM/4.0.0" 
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
    http://maven.apache.org/xsd/maven-4.0.0.xsd"&gt;
  &lt;modelVersion&gt;4.0.0&lt;/modelVersion&gt;
  &lt;groupId&gt;com.javacreed.examples&lt;/groupId&gt;
  &lt;artifactId&gt;how-to-run-embedded-tomcat-with-maven&lt;/artifactId&gt;
  &lt;version&gt;0.0.1-SNAPSHOT&lt;/version&gt;
  &lt;name&gt;How To Run Embedded Tomcat with Maven&lt;/name&gt;
  &lt;url&gt;http://www.javacreed.com/how-to-run-embedded-tomcat-with-maven/&lt;/url&gt;
  &lt;packaging&gt;war&lt;/packaging&gt;
  &lt;organization&gt;
    &lt;name&gt;Java Creed&lt;/name&gt;
    &lt;url&gt;http://www.javacreed.com/&lt;/url&gt;
  &lt;/organization&gt;

  &lt;properties&gt;
    &lt;project.build.sourceEncoding&gt;UTF-8&lt;/project.build.sourceEncoding&gt;
  &lt;/properties&gt;

  &lt;build&gt;
    &lt;plugins&gt;
      &lt;plugin&gt;
        &lt;artifactId&gt;maven-compiler-plugin&lt;/artifactId&gt;
        &lt;version&gt;2.3.2&lt;/version&gt;
        &lt;configuration&gt;
          &lt;source&gt;1.7&lt;/source&gt;
          &lt;target&gt;1.7&lt;/target&gt;
        &lt;/configuration&gt;
      &lt;/plugin&gt;

      <span class="highlight">&lt;plugin&gt;
        &lt;groupId&gt;org.apache.tomcat.maven&lt;/groupId&gt;
        &lt;artifactId&gt;tomcat7-maven-plugin&lt;/artifactId&gt;
        &lt;version&gt;2.2&lt;/version&gt;
        &lt;configuration&gt;
          &lt;port&gt;9090&lt;/port&gt;
          &lt;path&gt;/&lt;/path&gt;
        &lt;/configuration&gt;
      &lt;/plugin&gt;</span>
    &lt;/plugins&gt;
  &lt;/build&gt;
  
  &lt;dependencies&gt;
    &lt;dependency&gt;
      &lt;groupId&gt;javax.servlet&lt;/groupId&gt;
      &lt;artifactId&gt;javax.servlet-api&lt;/artifactId&gt;
      &lt;version&gt;3.0.1&lt;/version&gt;
      &lt;scope&gt;provided&lt;/scope&gt;
    &lt;/dependency&gt;
  &lt;/dependencies&gt;
&lt;/project&gt;
</pre>


Please note that the above configuration will start the embedded Tomcat instance on port <code>9090</code>.  You can change the port as required.


Build the project

<pre>
mvn clean install
</pre>


Start the embedded Tomcat server.

<pre>
mvn tomcat7:run
</pre>


This will produce something similar to the following.

<pre>
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building How To Run Embedded Tomcat with Maven 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] >>> tomcat7-maven-plugin:2.2:run (default-cli) @ how-to-run-embedded-tomcat-with-maven >>>
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ how-to-run-embedded-tomcat-with-maven ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 0 resource
[INFO]
[INFO] --- maven-compiler-plugin:2.3.2:compile (default-compile) @ how-to-run-embedded-tomcat-with-maven ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] <<< tomcat7-maven-plugin:2.2:run (default-cli) @ how-to-run-embedded-tomcat-with-maven <<<
[INFO]
[INFO] --- tomcat7-maven-plugin:2.2:run (default-cli) @ how-to-run-embedded-tomcat-with-maven ---
[INFO] Running war on http://localhost:9090/
[INFO] Creating Tomcat server configuration at C:\JavaCreed\examples\maven\How To Run Embedded Tomcat with Maven\target\tomcat
[INFO] create webapp with contextPath:
Mar 20, 2014 4:00:05 PM org.apache.coyote.AbstractProtocol init
INFO: Initializing ProtocolHandler ["http-bio-9090"]
Mar 20, 2014 4:00:05 PM org.apache.catalina.core.StandardService startInternal
INFO: Starting service Tomcat
Mar 20, 2014 4:00:05 PM org.apache.catalina.core.StandardEngine startInternal
INFO: Starting Servlet Engine: Apache Tomcat/7.0.47
Mar 20, 2014 4:00:07 PM org.apache.coyote.AbstractProtocol start
INFO: Starting ProtocolHandler ["http-bio-9090"]
</pre>


Please note that when executed for the first time, Maven may download any missing components and thus may produce more output than that shown above.


Open the browser.

<pre>
http://localhost:9090/hello
</pre>


You should see something similar to the following

<a href="http://www.javacreed.com/wp-content/uploads/2014/03/Embedded-Tomcat.png" class="preload" rel="prettyphoto" title="Embedded Tomcat" ><img src="http://www.javacreed.com/wp-content/uploads/2014/03/Embedded-Tomcat.png" alt="Embedded Tomcat" width="594" height="376" class="size-full wp-image-5094" /></a>


We managed to run a Java web application without having to install a web server such as Tomcat.
