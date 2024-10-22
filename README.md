![Java](https://img.shields.io/badge/Java-f8981d?style=for-the-badge&logo=openjdk&logoColor=black)
![Spring MVC](https://img.shields.io/badge/Spring%20MVC-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=bbae79)
![Liquibase](https://img.shields.io/badge/liquibase-2962FF.svg?style=for-the-badge&logo=liquibase&logoColor=white)
![Docker](https://img.shields.io/badge/docker-2496ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![gradle](https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white)

# О проекте

## Описание приложения

Список задач (to-do list) с возможностью просматривать задачи, добавлять новые, редактировать и удалять существующие.

## Задачи проекта

- Реализовать проект и не использовать Spring Boot, а самому разобраться, как все сконфигурировать.
- Упаковать приложение в Docker контейнер и настроить работу связки приложения с базой данных.

# Запуск

Приложение можете запустить как локально, так и в докере - нужная конфигурация настроится автоматически.

Инструкция для запуска в докере:

- Перейдите в папку проекта и в терминале выполните `docker compose -f guest.compose.yaml up`
- Перейдите по ссылке `http://localhost:8080/todo-list`
