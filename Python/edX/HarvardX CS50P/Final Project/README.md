<h1 align="center">Regression Visualizer</h1>

---

**Video Demo:** [Watch the Video Demo](https://youtu.be/ruhQ01tATbE)

**Description:** The objective of this project was to create a program that graphically demonstrates different types of regression, along with returning their equations, based on user input. This tool provides a visual way to understand the behavior of each type of regression.

**Motivation:** While studying at university, I encountered situations where I needed a tool like this to comprehend the behavior of various regression types. Not finding such a tool at that time motivated me to create one. With an improved understanding of Python now, I was able to implement this program myself.

**Project Overview:**
- The `project.py` file contains the calculation logic for three types of regression (Linear, Exponential, and Polynomial), as well as the plotting functionality. It's well-commented and utilizes docstrings and type hints to enhance project robustness.
- During development, I considered separating each type of regression into individual files, but I opted to keep all the code in a single file for simplicity and ease of code maintenance. To maintain clarity, I added comments to each function implementation.
- The `test_project.py` file contains unit tests written to verify the correctness of the regression methods.
- The `requirements.txt` file lists all the required modules for this program to run effectively.

**Usage:**
1. Clone this repository.
   ```bash
   git clone --no-checkout https://github.com/kayckdelfino/public_knowledge_base
   cd public_knowledge_base
   git sparse-checkout init --cone
   git sparse-checkout set 'Python/HarvardX CS50P/Final Project'
   git checkout
2. Go to Final Project folder.
   ```bash
   cd '.\Python\HarvardX CS50P\Final Project\'
3. Install the required modules using: `pip install -r requirements.txt`.
4. Run the program using: `python project.py`.

**Features:**
- Interactive menu for selecting regression types.
- Data input for each regression.
- Graphical visualization of the regression results.
- Equation output for each regression type.

---