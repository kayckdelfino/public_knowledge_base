const fs = require('fs');

fs.readFile("file.txt", "utf8", (error, text) => {
  if (error) {
    throw error;
  } else {
    console.log(text);
  }
});

fs.writeFile("file.txt", "Text written by write file", (error) => {
  if (error) {
    throw error;
  } else {
    console.log("Successfully written!");
  }
});