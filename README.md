# Автотесты для сайта letu.ua
![alt text](images/mainPage.png)
		Java		Gradle			Allure Report	Allure TO	Jenkins	Jira
# Использованы технологии:
| GitHub | IntelliJ IDEA | Java  | Junit5  |  Gradle | Selenide  | Selenoid  | Jenkins |Allure Report  |  Allure TestOps | Jira  |
|---|---|---|---|---|---|---|---|---|---|---|
| ![alt text](images/GitHub.svg)  |  ![alt text](images/IntelijIdea.svg) |  ![alt text](images/Java.svg) | ![alt text](images/Junit5.svg)  | ![alt text](images/Gradle.svg)  | ![alt text](images/Selenide.svg)  |  ![alt text](images/Selenoid.svg) | ![alt text](images/Jenkins.svg)  | ![alt text](images/AllureReport.svg)  | ![alt text](images/AllureTestOps.svg)  |  ![alt text](images/Jira.svg) |

# Запуск тестов с помощью CI Jenkins
<a target="_blank" href="https://jenkins.autotests.cloud/job/letu-tests/</a>
![alt text](images/JenkinsCI.png)

# Отчет генерируется в Allure
![alt text](images/allureReport_1.png)
![alt text](images/allureReport_2.png)

# Видео теста "Successful login"
![alt text](images/loginVideo.gif)

Команда для запуска тестов, когда файл local.properties заполнен параметрами:
```bash
gradle clean test
```
Команда для запуска тестов, когда файл local.properties не заполнен параметрами или с другими парамтрами "remoteDriverUrl", "videoStorage", "threads":
- DremoteDriverUrl в этом параметре необходимо указать логин (вместо %s), пароль (вместо %s2) и адрес удаленного сервера (в данном случае "selenoid.autotests.cloud/wd/hub/")
- DvideoStorage в этом параметре необходимо указать место для сохранения видео (в данном случае "https://selenoid.autotests.cloud/video/")
- Dthreads в этом параметре необходимо указать колличество потоков (в данном случае 1 поток)
```bash
 gradle clean -DremoteDriverUrl=https://%s:%s2@selenoid.autotests.cloud/wd/hub/ -DvideoStorage=https://selenoid.autotests.cloud/video/ -Dthreads=1 test
```
Генерация отчета:
```bash
allure serve build/allure-results
```
