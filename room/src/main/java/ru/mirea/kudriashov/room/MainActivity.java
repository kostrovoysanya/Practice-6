package ru.mirea.kudriashov.room;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String TAG = ru.mirea.kudriashov.room.MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ru.mirea.kudriashov.room.AppDatabase db = ru.mirea.kudriashov.room.App.getInstance().getDatabase();
        ru.mirea.kudriashov.room.EmployeeDao employeeDao = db.employeeDao();
        ru.mirea.kudriashov.room.Employee employee = new ru.mirea.kudriashov.room.Employee();
        employee.id = 1;
        employee.name = "John Smith";
        employee.salary = 10000;
// запись сотрудников в базу
        employeeDao.insert(employee);
// Загрузка всех работников
        List<ru.mirea.kudriashov.room.Employee> employees = employeeDao.getAll();
// Получение определенного работника с id = 1
        employee = employeeDao.getById(1);
// Обновление полей объекта
        employee.salary = 20000;
        employeeDao.update(employee);
        Log.d(TAG, employee.name + " " + employee.salary);
    }
}