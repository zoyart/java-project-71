### **STATUSES**:
[![Actions Status](https://github.com/zoyart/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/zoyart/java-project-71/actions) [![Actions Status](https://github.com/zoyart/java-project-71/actions/workflows/makefile.yml/badge.svg)](https://github.com/zoyart/java-project-71/actions) [![Maintainability](https://api.codeclimate.com/v1/badges/4a8a2accd783a1122f43/maintainability)](https://codeclimate.com/github/zoyart/java-project-71/maintainability) [![Test Coverage](https://api.codeclimate.com/v1/badges/4a8a2accd783a1122f43/test_coverage)](https://codeclimate.com/github/zoyart/java-project-71/test_coverage)
# Why is it needed?
The program compares two “json” or "yml" documents and displays a report in one of the selected formats.
# Usage
[![asciicast](https://asciinema.org/a/sVzHlEFoaa2eajuiVUIx1qbNi.svg)](https://asciinema.org/a/sVzHlEFoaa2eajuiVUIx1qbNi)
## Params
When starting the program, you must specify two mandatory parameters - the path to the first and second files that need to be compared.
## Available formats
[![asciicast](https://asciinema.org/a/MTGXS1OQcLJy5gagd0MZiDqFU.svg)](https://asciinema.org/a/MTGXS1OQcLJy5gagd0MZiDqFU)
### stylish - used by default
If the parameter does not have a prefix, it means that it has not changed:
```text
"   name: Oleg"
```
This means that the parameter was added in the second file:
```text
" + name: Oleg"
```
This means that the parameter has been changed:
```text
" - name: Artur"
" + name: Oleg"
```
### plain
The plain format does not display parameters that have not been changed.
If the parameter value is an array, or a set of keys, then it is converted to the inscription: "[complex value]".
### json
Json is generated in the following format:
```json
{
  "ADDED":[
    {
      "type":"ADDED",
      "oldValue":null,
      "newValue":"value2"
    }
  ],
  "UPDATED":[
    {
      "type":"UPDATED",
      "oldValue":["d", "e", "f"],
      "newValue":false
    }
  ]
}
```