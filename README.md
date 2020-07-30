# UpHill GitHub Powered Recruiting Tool

The objective is to develop a service that allows the discovery of possible candidates by their location and code skills and the selection and revision of the ones that seem relevant for some job position.

### Notes:

To manually test the API please import the file in the _postman_collections_ to Postman and use those endpoints.

Every request need to be authenticated. To do this when using Postman, go to to the _Authorization_ tab, choose _Basic Auth_ in _Type_ and the insert the username (_admin_) and password (_admin_), and finally do the request.

### Tech Stack:

- Java 11
- Spring Boot
- Spring Security
- Hibernate
- H2 Database (in-memory)
- JUnit
- Mockito

### Setup:

- Clone project to a folder
- Run the application with:
  - _mvn clean install_
  - _mvn spring-boot:run_
- Test the application with:
  - _mvn test_ -> run all tests
  - _mvn -Dtest=TestClass test_ -> run a single test class
  - _mvn -Dtest=TestClass1,TestClass2 test_ -> run multiple test classes
- Package the application with _mvn package_
- Test using Postman

### To Use With Docker:
  - Install Docker on your machine
  - Launch Docker
  - Run the command _sudo systemctl status docker_ to confirm Docker is running
  - Open terminal in the project folder
  - Run the command _mvn clean install_
  - Run the command _sudo docker build -t [NAME_OF_IMAGE] ._ to create the Docker image. Replace _NAME_OF_IMAGE_ with a name for that image like, for example, _uphill-solution_
  - Run the command _sudo docker run -p 8080:8080 [NAME_OF_IMAGE]_ to launch the application
  - Test using Postman
  
  ## Endpoints:

Below are documented the endpoints of the API of this project. There are also some examples of possible outcomes that might happen when using the API.

* User GitHub Search:
  
   **Get all user that match the query parameters. Parameters are optional but at least one of them must be present** - **GET** uphill/api/github-search?location={location}&language={language}&followers={followers}
   
   URL:
    
      http://localhost:8080/uphill/api/github-search?location=lisbon&language=java&followers=1000
      
   Authorization:
      
      Basic Auth 
      Username - admin
      Password - admin
      
   Response Status:
      
      200 OK
      
   Body:
      
      Empty
      
   Return:
    
      [
        {
          "name": "Stephane Maarek",
          "company": "@datacumulus",
          "blog": "https://courses.datacumulus.com/",
          "location": "Lisbon + moving around the world",
          "email": "N.A.",
          "bio": "Kafka & AWS evangelist, Udemy instructor, love finding problems that are patiently waiting to be solved.",
          "numberOfFollowers": 3131,
          "numberOfFollowing": 9,
          "gitHubUrl": "https://github.com/simplesteph",
          "repos": [
              "https://github.com/simplesteph/ansible",
              "https://github.com/simplesteph/ansible-modules-core",
              "https://github.com/simplesteph/ansible-modules-extras",
              "https://github.com/simplesteph/awesome-grpc",
              "https://github.com/simplesteph/awesome-kafka",
              "https://github.com/simplesteph/AWS-FAQ",
              "https://github.com/simplesteph/aws-lambda-septime",
              "https://github.com/simplesteph/azure-docs",
              "https://github.com/simplesteph/azure-event-hubs-java",
              "https://github.com/simplesteph/cp-docker-images",
              "https://github.com/simplesteph/docker-kerberos-get-keytab",
              "https://github.com/simplesteph/ec2-masterclass-sampleapp",
              "https://github.com/simplesteph/ecs-gen",
              "https://github.com/simplesteph/ecs-nginx-proxy",
              "https://github.com/simplesteph/ecs-refarch-cloudformation",
              "https://github.com/simplesteph/evans",
              "https://github.com/simplesteph/exhibitor",
              "https://github.com/simplesteph/fast-data-dev",
              "https://github.com/simplesteph/foodiz_factual_fetch",
              "https://github.com/simplesteph/fxldemo-gradle",
              "https://github.com/simplesteph/grpc-csharp-course",
              "https://github.com/simplesteph/grpc-go-course",
              "https://github.com/simplesteph/grpc-java",
              "https://github.com/simplesteph/grpc-java-course",
              "https://github.com/simplesteph/ish",
              "https://github.com/simplesteph/jmx_exporter",
              "https://github.com/simplesteph/kafka",
              "https://github.com/simplesteph/kafka-0.11-examples",
              "https://github.com/simplesteph/kafka-avro-course",
              "https://github.com/simplesteph/kafka-beginners-course"
          ]
        }
      ]
      
* User Reviewed:

   **Save a GitHub user that has been reviewed** - **POST** uphill/api/recruiting
      
   URL:
      
      http://localhost:8080/uphill/api/recruiting
      
   Authorization:
      
      Basic Auth 
      Username - admin
      Password - admin
      
   Response Status:
      
      201 CREATED
      
   Body:
      
      {
        "jobCategory": "Backend",
        "skillLevel": "Junior",
        "fitForJobScale": 3,
        "commentary": "Testing",
        "name": "Stephane Maarek",
        "company": "@datacumulus",
        "blog": "https://courses.datacumulus.com/",
        "location": "Lisbon + moving around the world",
        "email": "N.A.",
        "bio": "Kafka & AWS evangelist, Udemy instructor, love finding problems that are patiently waiting to be solved.",
        "numberOfFollowers": 3130,
        "numberOfFollowing": 9,
        "gitHubUrl": "https://github.com/simplesteph",
        "repos": [
            "https://github.com/simplesteph/ansible",
            "https://github.com/simplesteph/ansible-modules-core",
            "https://github.com/simplesteph/ansible-modules-extras",
            "https://github.com/simplesteph/awesome-grpc",
            "https://github.com/simplesteph/awesome-kafka",
            "https://github.com/simplesteph/AWS-FAQ",
            "https://github.com/simplesteph/aws-lambda-septime",
            "https://github.com/simplesteph/azure-docs",
            "https://github.com/simplesteph/azure-event-hubs-java",
            "https://github.com/simplesteph/cp-docker-images",
            "https://github.com/simplesteph/docker-kerberos-get-keytab",
            "https://github.com/simplesteph/ec2-masterclass-sampleapp",
            "https://github.com/simplesteph/ecs-gen",
            "https://github.com/simplesteph/ecs-nginx-proxy",
            "https://github.com/simplesteph/ecs-refarch-cloudformation",
            "https://github.com/simplesteph/evans",
            "https://github.com/simplesteph/exhibitor",
            "https://github.com/simplesteph/fast-data-dev",
            "https://github.com/simplesteph/foodiz_factual_fetch",
            "https://github.com/simplesteph/fxldemo-gradle",
            "https://github.com/simplesteph/grpc-csharp-course",
            "https://github.com/simplesteph/grpc-go-course",
            "https://github.com/simplesteph/grpc-java",
            "https://github.com/simplesteph/grpc-java-course",
            "https://github.com/simplesteph/ish",
            "https://github.com/simplesteph/jmx_exporter",
            "https://github.com/simplesteph/kafka",
            "https://github.com/simplesteph/kafka-0.11-examples",
            "https://github.com/simplesteph/kafka-avro-course",
            "https://github.com/simplesteph/kafka-beginners-course"
        ]
      }
      
   Return:
   
      {
        "id": 1,
        "jobCategory": "Backend",
        "skillLevel": "Junior",
        "fitForJobScale": 3,
        "commentary": "Testing",
        "name": "Stephane Maarek",
        "company": "@datacumulus",
        "blog": "https://courses.datacumulus.com/",
        "location": "Lisbon + moving around the world",
        "email": "N.A.",
        "bio": "Kafka & AWS evangelist, Udemy instructor, love finding problems that are patiently waiting to be solved.",
        "numberOfFollowers": 3130,
        "numberOfFollowing": 9,
        "gitHubUrl": "https://github.com/simplesteph",
        "repos": [
            "https://github.com/simplesteph/ansible",
            "https://github.com/simplesteph/ansible-modules-core",
            "https://github.com/simplesteph/ansible-modules-extras",
            "https://github.com/simplesteph/awesome-grpc",
            "https://github.com/simplesteph/awesome-kafka",
            "https://github.com/simplesteph/AWS-FAQ",
            "https://github.com/simplesteph/aws-lambda-septime",
            "https://github.com/simplesteph/azure-docs",
            "https://github.com/simplesteph/azure-event-hubs-java",
            "https://github.com/simplesteph/cp-docker-images",
            "https://github.com/simplesteph/docker-kerberos-get-keytab",
            "https://github.com/simplesteph/ec2-masterclass-sampleapp",
            "https://github.com/simplesteph/ecs-gen",
            "https://github.com/simplesteph/ecs-nginx-proxy",
            "https://github.com/simplesteph/ecs-refarch-cloudformation",
            "https://github.com/simplesteph/evans",
            "https://github.com/simplesteph/exhibitor",
            "https://github.com/simplesteph/fast-data-dev",
            "https://github.com/simplesteph/foodiz_factual_fetch",
            "https://github.com/simplesteph/fxldemo-gradle",
            "https://github.com/simplesteph/grpc-csharp-course",
            "https://github.com/simplesteph/grpc-go-course",
            "https://github.com/simplesteph/grpc-java",
            "https://github.com/simplesteph/grpc-java-course",
            "https://github.com/simplesteph/ish",
            "https://github.com/simplesteph/jmx_exporter",
            "https://github.com/simplesteph/kafka",
            "https://github.com/simplesteph/kafka-0.11-examples",
            "https://github.com/simplesteph/kafka-avro-course",
            "https://github.com/simplesteph/kafka-beginners-course"
        ]
      }
      
   **Get all GitHub users that have been reviewed** - **GET** uphill/api/recruiting
      
   URL:
      
      http://localhost:8080/uphill/api/recruiting
      
   Authorization:
      
      Basic Auth 
      Username - admin
      Password - admin
      
   Response Status:
      
      200 OKAY
      
   Body:
      
      Empty
      
   Return:  
   
      [
        {
          "id": 1,
          "jobCategory": "Backend",
          "skillLevel": "Junior",
          "fitForJobScale": 3,
          "commentary": "Testing",
          "name": "Stephane Maarek",
          "company": "@datacumulus",
          "blog": "https://courses.datacumulus.com/",
          "location": "Lisbon + moving around the world",
          "email": "N.A.",
          "bio": "Kafka & AWS evangelist, Udemy instructor, love finding problems that are patiently waiting to be solved.",
          "numberOfFollowers": 3131,
          "numberOfFollowing": 9,
          "gitHubUrl": "https://github.com/simplesteph",
          "repos": [
              "https://github.com/simplesteph/ansible",
              "https://github.com/simplesteph/ansible-modules-core",
              "https://github.com/simplesteph/ansible-modules-extras",
              "https://github.com/simplesteph/awesome-grpc",
              "https://github.com/simplesteph/awesome-kafka",
              "https://github.com/simplesteph/AWS-FAQ",
              "https://github.com/simplesteph/aws-lambda-septime",
              "https://github.com/simplesteph/azure-docs",
              "https://github.com/simplesteph/azure-event-hubs-java",
              "https://github.com/simplesteph/cp-docker-images",
              "https://github.com/simplesteph/docker-kerberos-get-keytab",
              "https://github.com/simplesteph/ec2-masterclass-sampleapp",
              "https://github.com/simplesteph/ecs-gen",
              "https://github.com/simplesteph/ecs-nginx-proxy",
              "https://github.com/simplesteph/ecs-refarch-cloudformation",
              "https://github.com/simplesteph/evans",
              "https://github.com/simplesteph/exhibitor",
              "https://github.com/simplesteph/fast-data-dev",
              "https://github.com/simplesteph/foodiz_factual_fetch",
              "https://github.com/simplesteph/fxldemo-gradle",
              "https://github.com/simplesteph/grpc-csharp-course",
              "https://github.com/simplesteph/grpc-go-course",
              "https://github.com/simplesteph/grpc-java",
              "https://github.com/simplesteph/grpc-java-course",
              "https://github.com/simplesteph/ish",
              "https://github.com/simplesteph/jmx_exporter",
              "https://github.com/simplesteph/kafka",
              "https://github.com/simplesteph/kafka-0.11-examples",
              "https://github.com/simplesteph/kafka-avro-course",
              "https://github.com/simplesteph/kafka-beginners-course"
          ]
        }
      ]
