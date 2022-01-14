# selenium-ecommerce website testing
University Project - testing E-commerce website with Selenium Framework


# prerequisites for eclipse
1. install TestNG in IDE
2. run testng_all.xml as TestNG Suite

# prerequisites for jenkins
1. start jenkins in cmd (java -jar jenkins.war --httpPort=8080)
2. set jenkins security configuration for Extent Report html viewing
  System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "default-src * 'unsafe-inline' 'unsafe-eval'; script-src * 'unsafe-inline' 'unsafe-eval'; connect-src * 'unsafe-     inline'; img-src * data: blob: 'unsafe-inline'; frame-src *; style-src * 'unsafe-inline';"
3. run build
4. view Extent Report
