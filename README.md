# Simple Substitution Cipher Tool

Small console Java program that encrypts and decrypts short secret messages using a fixed substitution alphabet (A–Z + space). It also preserves the original letter casing by saving a parallel casing pattern so your decrypted text can be restored exactly.

---

## Features

* Encrypt plaintext (letters + spaces) into symbol cipher text.
* Decrypt cipher text back to readable text.
* Preserves uppercase / lowercase via a separate casing pattern string.
* Save / load encrypted text and casing info from simple `.txt` files.

---

## How to Use (Menu)

When you run the program you’ll see a menu:

**E** – *Encrypt* a message you type.

* Saves two files:

  * `encryptedMessage.txt` – the encrypted symbols.
  * `casingInfo.txt` – casing pattern ("U" for uppercase, "l" for lowercase, space for all other chars).

**D** – *Decrypt*.

* Choose **R** to read the encrypted text + casing pattern from the saved files.
* Choose **M** to paste / type the encrypted string and casing pattern manually.

**Q** – Quit.

---

## Not Real Security!

This is a **classroom / demo tool**. The cipher is easily broken and not suitable for real confidential or personal data.



