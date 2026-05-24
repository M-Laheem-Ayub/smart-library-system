# Smart Library System 📚 - SCD Assignment 3

A Java Swing-based Desktop Application for managing library book issuance. This project was developed as **Assignment 3** for the **Software Construction & Development (SCD - SESD3242)** course at the University of Central Punjab (UCP).

* **Deadline:** 24-May-2026
* **Course Instructor:** [Ma'am Hafiza Maria Kiran](https://www.linkedin.com/in/maria-kiran-372174225/)

## 🌟 Features & Exception Handling
This application includes robust backend validation using Java Exception Handling (`try-catch`, `throw`, and `finally`).

* **EmptyFieldException**: Prevents submission if mandatory fields (Name, Roll No, Title) are blank.
* **InvalidRollNumberException**: Validates the roll number format (ensures no alphabets and valid length).
* **NullSelectionException**: Ensures a book edition type is selected.
* **InvalidDateException**: Compares issue and return dates ensuring logical chronological order.
* **NumberFormatException**: Handles parsing errors for numeric inputs.
* **Finally Block Cleanup**: Ensures a guaranteed completion message dialog at the end of every transaction.

## 👥 Contributors (BSSE 6th Semester)
* **Laheem Ayub** (L1F23BSSE0176) - Text fields validation, `EmptyFieldException`, `InvalidRollNumberException`, Repo setup.
* **Muhammad Umar** (L1F23BSSE0137) - Dates & dropdown validations, `NullSelectionException`, `InvalidDateException`, `finally` block logic.

---

## 📸 GUI Screenshots

Here are the various states and validation outputs of the application:

### 1. Main Application Interface
![Main UI](GUI%20screenshots/Original%20Blank%20Form.png)

### 2. Validation: Empty Fields
![Empty Field Error](GUI%20screenshots/Empty%20Field%20Exception%20Box.png)

### 3. Validation: Invalid Roll Number
![Invalid Roll No Error](GUI%20screenshots/Invalid%20Roll%20Number%20Box.png)

### 4. Validation: Logical Date Error
![Invalid Date Error](GUI%20screenshots/Invalid%20Date%20Exception%20Box.png)

### 5. Successful Book Issuance
![Success Dialog](GUI%20screenshots/Success%20Dialog%20%20Box.png)

### 6. Transaction Completed (Finally Block)
![Finally Block](GUI%20screenshots/Finally%20Block%20Completion%20Box.png)
