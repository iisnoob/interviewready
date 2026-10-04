# Singleton Design Pattern
Ensures that a class has only one instance/object throughout the application with global way to access it. E.g. One single WebClient object in Spring WebFlux, one single RouteLocator object in SpringCloudGateway, one single Logger object globally available for the entire application. @Configuration<br>
@Bean<br>
public [Logger OR RouteLocator OR WebClient] someMethod(...)<br>
return ... ;<br>}