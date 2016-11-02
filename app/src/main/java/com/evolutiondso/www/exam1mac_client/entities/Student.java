package com.evolutiondso.www.exam1mac_client.entities;

import com.google.android.gms.common.api.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Albrtx on 01/11/2016.
 */

public class Student {

        String name;
        String age;
        String password;
        float grade;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public float getGrade() {
            return grade;
        }

        public void setGrade(float grade) {
            this.grade = grade;
        }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", password='" + password + '\'' +
                ", grade=" + grade +
                '}';
    }
}

