package com.prac;

import java.lang.reflect.Field;

public class NullCheck {

    public static void main(String[] args) throws NoSuchFieldException {
        validateFields(Employee.class, "mobile", "email");
    }

    private static void validateFields(Class classType, String... variables) throws NoSuchFieldException {
        Field[] field = classType.getClass().getDeclaredFields();

        for (String str : variables){
            System.out.println(classType.getField(str));
        }

        //
//        for (int j = 0; j < field.length; j++) {
//
//            String name = field[j].getName();
//            name = name.substring(0, 1).toUpperCase() + name.substring(1);
//            String type = field[j].getGenericType().toString();
//
//            System.out.println(type+" "+name);
//
//        }
    }

    static class Employee {
        private String name;
        private String mobile;
        private String firstName;
        private String email;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}

