# formz-be

# ForMZ - Youth Empowerment: Navigating National Support Policies and Programs for a Brighter Tomorrow

![ForMZ Logo](link_to_logo.png)

ForMZ is a project dedicated to providing information about various government support policies and programs for young individuals. Leveraging technologies such as Spring Boot, Jenkins, Nginx, Docker, and AWS services, we aim to create a robust platform that facilitates easy access to valuable resources for the youth.

## Project Overview

As the name suggests, ForMZ focuses on empowering the youth by delivering comprehensive details about national support policies and diverse programs. The project's key features include:

- Centralized repository of information on government initiatives.
- User-friendly interface for easy navigation and access to relevant content.
- Integration of <b>Spring Boot</b> for efficient backend development.
- Continuous integration and deployment using <b>Jenkins</b>.
- Scalability and containerization through <b>Docker</b>.
- Hosting on <b>AWS</b> for reliable and scalable infrastructure.
- Efficient web serving with <b>Nginx</b>.

</br>

## System Architecture 

<img width="880px" src="https://github.com/For-MZ/formz-be/assets/102718303/2464f498-6260-4f88-a116-aeb851b671ea">

</br>

## Installation Guide

To set up the ForMZ project locally, follow these steps:

1. Clone the repository:
2. Navigate to the project directory:<Br>
cd your-spring-boot-project
3. Install Java 17:<Br>
Ensure you have Java 17 installed on your machine.<Br>
4. Install Docker:<Br>
Install Docker following the instructions for your operating system.<Br>
~Docker Installation Guide~
5. Install Jenkins:<Br>
Set up Jenkins using Docker. Replace your-jenkins-port with the desired port.<Br>
docker run -p your-jenkins-port:8080 -v jenkins_home:/var/jenkins_home jenkins/jenkins:lts<Br>
Access Jenkins in your web browser: http://localhost:your-jenkins-port<Br>
6. Build and Run the Spring Boot Project:
Use the following commands to build and run your Spring Boot application.<Br>
7. Access the Application:<Br>
Open http://localhost:your_application_port in your web browser.

