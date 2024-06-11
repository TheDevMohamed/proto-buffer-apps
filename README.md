# Proto Buffer Apps

This repository contains two Spring Boot applications utilizing Protocol Buffers.

## Contents

- `proto-buffer-app-one`: First Spring Boot application with Protocol Buffers. This is the sender application.
- `proto-buff-app-two`: Second Spring Boot application with Protocol Buffers. This is the receiver application.

## Requirements

- Java 11 or higher
- Maven 3.6.3 or higher

## Getting Started

### Clone the repository

#### Navigate to proto-buff-app-one and build & run the app. DO the same for proto-buff-app-two

```bash
git clone https://github.com/TheDevMohamed/proto-buffer-apps.git
cd proto-buffer-apps/proto-buff-app-one
mvn clean install
mvn spring-boot:run
cd ../proto-buff-app-two
mvn clean install
mvn spring-boot:run
```

### Accessing the applications
#### Navigate to each application's directory and use the following command:
<ul>
  <li>proto-buffer-app-one: http://localhost:8080</li>
  <li>proto-buff-app-two: http://localhost:8081</li>
</ul>

### Contributing
####Feel free to open issues or submit pull requests.

### Contact
#### For any inquiries, please reach out to [TheDevMohamed](hhttps://github.com/TheDevMohamed").

