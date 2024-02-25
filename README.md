# 🏝️ Fairy-Tale Island 🏝️
![image](https://github.com/GDSC-CAU/FTIsland-BE/assets/81238093/f99316f4-59f0-460b-a0cd-356fd96c553b)
(간단한 설명)
### Demo video

## 📌 Problem

## 📌 Solution

## 📌 UN-SDGs

## 📌 Architecture
![image](https://github.com/GDSC-CAU/FTIsland-BE/assets/81238093/5f40878e-c43b-4642-8406-0ce5375903b2)


### Google Products
- Google Cloud Platform
- Google Cloud Storage (Bucket)
- Google Cloud SQL
- Google translation API
- Google text to speech API

## 📌 Start Guide

## Front-end

### Requirements
Before getting started, ensure you have the following installed:

- Node.js
- npm (Node Package Manager)

### Install and Clone
1. Clone the Repository:

```
git clone https://github.com/GDSC-CAU/FTIsland-FE.git
```

2. Change Directory:

```
cd FTIsland-FE
```

3. Install Dependencies:

```
npm install
```

### Environment Variables Setup
1. Create a .env.local File
- Create a .env.local file in the root directory of your project.

2. Set Environment Variables
- Set the required environment variables in the .env file. For example:

```
NEXT_PUBLIC_GOOGLE_CLOUD_API_KEY={your gcp key}
NEXT_PUBLIC_SERVER_URL=https://..
```

### Run
To run the front-end application, follow these steps:

1. Development Mode:

```
npm start
```

2. Test
- Open http://localhost:3000 with your browser to see the result.


## Back-end

### Requirements
Before getting started, ensure you have the following installed:

- MySQL
- Java (JDK17)
- IntelliJ IDEA

### Install and Clone
- Clone the Repository:

```
git clone https://github.com/GDSC-CAU/FTIsland-BE.git
```
- Open
1. In IntelliJ IDEA, open the folder for that clone path and select the "build.gradle" file to open it.
2. When the gradle plug-in elephant appears, press it to add dependency.
3. If you have a build problem, change to Build Tools in settings: IntelliJIDEA -> Gradle or vice versa.
4. If you still have a problem, set the gradle JVM version to 17.


### Environment Variables Setup
1. You must enter the API Key in the yml file to run. Running as it is may not support some of the features.
2. The mysql setting must be as follows.

- In mySQL workbench, set the root user's password to 0000.
```
mysql -u root
```
```
set password = password('0000');
```

- Create database under the name 'ft'
```
create database ft;
```
### Run
- In "com.FTIsland.BE" folder, Run "BeApplication" file.
- Test </br>
  Open http://localhost:8080 or use the POSTMAN to check the api operation.


## 📌 Screen Shots

## 📌 Next Steps

## 📌 Contributors

| Minkyeong Kim | Yunjin Kim | Youngeun Jun | Seungwon Choi |
| --- | --- | --- | --- |
| <img src="https://github.com/GDSC-CAU/FTIsland-BE/assets/80468377/718adbac-97b2-4f1b-a312-4143108c8dd4" width="150" /> | <img src="https://github.com/GDSC-CAU/FTIsland-BE/assets/81238093/395dcbea-2778-47d8-ad97-8566606e029a" width="150" /> |  | <img src="https://github.com/GDSC-CAU/FTIsland-BE/assets/33658057/b6934dab-2bba-4533-982d-847684b9fcfe" width="150" /> |
| Back-end / AI | Server / Back-end | Front-end / Design | Front-end / Design |



