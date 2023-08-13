# CS50 Shirtificate
# Suppose that you’d like to implement a CS50 “shirtificate,” a PDF with an image of an I took CS50 t-shirt, shirtificate.png, customized with a user’s own name.
# 
# In a file called shirtificate.py, implement a program that prompts the user for their name and outputs, using fpdf2, a CS50 shirtificate in a file called shirtificate.pdf similar to this one for John Harvard, with these specifications:
# 
#     - The orientation of the PDF should be Portrait.
#     - The format of the PDF should be A4, which is 210mm wide by 297mm tall.
#     - The top of the PDF should say “CS50 Shirtificate” as text, centered horizontally.
#     - The shirt’s image should be centered horizontally.
#     - The user’s name should be on top of the shirt, in white text.
# 
# All other details we leave to you. You’re even welcome to add borders, colors, and lines. And no need to wrap long names across multiple lines.
# 
# Before writing any code, do read through fpdf2’s tutorial to learn how to use it. Then skim fpdf2’s API (application programming interface) to see all of its functions and parameters therefor.
# 
# Hints
# - Note that fpdf2 comes with a class called FPDF, which has quite a few methods, per py-pdf.github.io/fpdf2/fpdf/#fpdf.FPDF. You can install it with:
# pip install fpdf2
# - Note that you can extend FPDF and instantiate your own subclass thereof in order to add a header to every page of a PDF, per py-pdf.github.io/fpdf2/Tutorial.html#tuto-2-header-footer-page-break-and-image. Or you can add it as text yourself.
# - Note that you can disable automatic page breaks, which might otherwise cause your PDF to overflow from one page to two, with set_auto_page_break, per py-pdf.github.io/fpdf2/Margins.html.
# - Note that a cell’s height can be negative, to move it upward.
# - You can open shirtificate.pdf, once outputted, by clicking it in VS Code’s file explorer.
# 
# Demo
# $ python shirtificate.py
# Name: John Harvard


from fpdf import FPDF


class PDF():
    def __init__(self, name):
        self._pdf = FPDF()
        self._pdf.add_page()
        self._pdf.set_font("helvetica", "B", 50)
        self._pdf.cell(0, 60, "CS50 Shirtificate", new_x="LMARGIN", new_y="NEXT", align="C")
        self._pdf.image("shirtificate.png", w=self._pdf.epw)
        self._pdf.set_font_size(25)
        self._pdf.set_text_color(255, 255, 255)

        text = f"{name} took CS50"
        text_w = self._pdf.get_string_width(text)
        x_pos = (self._pdf.w - text_w) / 2
        self._pdf.text(x=x_pos, y=140, txt=text)


    def save(self, name):
        self._pdf.output(name)


def main():
    pdf = PDF(input("Name: "))
    pdf.save("shirtificate.pdf")


if __name__ == "__main__":
    main()