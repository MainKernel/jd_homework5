package com.jdbc.jdhomework5.feature.database;

import java.sql.*;
import java.time.LocalDate;

public class DBPopulateService {
    private PreparedStatement addWorker;
    private PreparedStatement selectWorkerWithID;

    private PreparedStatement addProject;

    private PreparedStatement addClient;
    private PreparedStatement addProjectWorker;

    public DBPopulateService(Storage storage) {
        Connection connection = storage.getConnection();
        try {
            this.addWorker = connection.prepareStatement(
                    "INSERT INTO WORKER (name, birthday, level, salary) VALUES (?,?,?,?)"
            );
            this.selectWorkerWithID = connection.prepareStatement(
                    "SELECT name, BIRTHDAY, LEVEL, SALARY FROM WORKER WHERE ID = ?"
            );

            this.addClient = connection.prepareStatement(
                    "INSERT INTO CLIENT (NAME) VALUES (?)"
            );

            this.addProject = connection.prepareStatement(
                    "INSERT INTO PROJECT (CLIENT_ID, START_DATE, FINISH_DATE) VALUES (?,?,?)"
            );

            this.addProjectWorker = connection.prepareStatement(
                    "INSERT INTO PROJECT_WORKER (PROJECT_ID, WORKER_ID) values (?,?)"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean addWorker(String name, LocalDate birthday, String level, int salary) {
        try {
            addWorker.setString(1, name);
            addWorker.setString(2, birthday.toString());
            addWorker.setString(3, level);
            addWorker.setInt(4, salary);
            return addWorker.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ResultSet findWorker(int id) {
        try {
            selectWorkerWithID.setInt(1, id);
            return selectWorkerWithID.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addClient(String name) {
        try {
            addClient.setString(1, name);
            return addClient.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addProject(int clientId, LocalDate startDate, LocalDate finishDate) {
        try {
            addProject.setInt(1, clientId);
            addProject.setString(2, startDate.toString());
            addProject.setString(3, finishDate.toString());
            return addClient.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addProjectWorker(int projectId, int workerId) {
        try {
            addProjectWorker.setInt(1, projectId);
            addProjectWorker.setInt(2, workerId);
            return addProjectWorker.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}

