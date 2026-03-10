# 📜 Scanner EBNF Grammar and Example Valid Code

## 📝 EBNF Grammar
```ebnf
program      ::= { token } ;
token        ::= number | symbol | invalid ;
number       ::= digit ;
symbol       ::= "+" | "-" | "=" ;
invalid      ::= any_character_except_digit_or_symbol ;
digit        ::= "0" | "1" | "2" | "3" | "4" | "5" | "6" | "7" | "8" | "9" ;
```

## 🔍 Explanation of the Scanner Behavior
- **`number`**: A single digit (`0-9`) is classified as a `number`.
- **`symbol`**: The characters `"+"`, `"-"`, `"="` are classified as `term` (symbol).
- **`invalid`**: Any character that is **not a number or symbol** is classified as `invalid`.
- **Whitespace (`" "`, `"\n"`, `"\t"`)** is **ignored**.

---

## ✅ Example Valid Code for This Scanner

### **Input String:**
```plaintext
3 + 5 - x = 7
```

### **Expected Token Output:**
```

number: "3"
term: "+"
number: "5"
term: "-"
invalid: "x"
term: "="
number: "7"
