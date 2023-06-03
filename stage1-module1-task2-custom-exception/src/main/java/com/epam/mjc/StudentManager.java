package com.epam.mjc;


public class StudentManager {

  class MyException extends IllegalArgumentException {
    private final String message;

    public MyException (long id) {
      super("Could not find student with ID " + id);
      this.message = "Could not find student with ID " + id;
    }

    @Override
    public String getMessage() {
      return this.message;
    }
  }

  private static final long[] IDs = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

  public Student find(long studentID) {
    if (studentID > 10) {
      throw new MyException(studentID);
    } else {
      return Student.getValueOf(studentID);
    }
  }

  public static void main(String[] args) {
    StudentManager manager = new StudentManager();

    for (int i = 0; i < IDs.length; i++) {
      Student student = manager.find(IDs[i]);
      System.out.println("Student name " + student.getName());
    }

  }
}