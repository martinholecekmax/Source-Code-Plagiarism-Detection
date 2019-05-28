"""
Author:         Martin Holecek
Date created:   14/02/2019
Description:    Obfuscate source code by changing names of identifiers, 
                adding or removing new lines, deleting single lines comments
"""
import javalang
import random
import string
import re

keywords = ['abstract', 'continue', 'for', 'new', 'switch', 'assert', 'default', 'goto', 'package',
            'synchronized', 'boolean', 'do', 'if', 'private', 'this', 'break', 'double', 'implements', 'protected',
            'throw', 'byte', 'else', 'import', 'public', 'throws', 'case', 'enum', 'instanceof', 'return',
            'transient', 'catch', 'extends', 'int', 'short', 'try', 'char', 'final', 'interface', 'static',
            'void', 'class', 'finally', 'long', 'strictfp', 'volatile', 'const', 'float', 'native', 'super', 'while']


def get_tokenized_source_code(filename):
    """ Get list of keywords and characters without variable names """
    with open(filename) as file:
        tokens = list(javalang.tokenizer.tokenize(file.read()))
        all_words = []
        for token in tokens:
            if token.value not in keywords:
                if re.search('[a-zA-Z]+', token.value):
                    continue
            all_words.append(token.value)
    return all_words


def get_identifieres(filename):
    """ Get list of variable's and method's names from source code """
    with open(filename) as file:
        tokens = list(javalang.tokenizer.tokenize(file.read()))
        all_words = []
        for token in tokens:
            if token.value not in keywords:
                if re.search('[a-zA-Z]+', token.value):
                    all_words.append(token.value)
    return all_words


def process(lines, variables, obfuscate=True, rm_comments=False, blanks=None):
    """ 
    Process array of the file
    - Obfuscation
    - Removing Comments
    - Adding or Removing Blank lines ('add', 'remove')
    Return: String - modified file string
    """
    full_text = ""
    for line in lines:
        if obfuscate:
            line = obfuscation(line, variables)
        if blanks == 'remove':
            line = remove_blank_lines(line)
        if blanks == 'add':
            line += add_blank_lines()
        full_text += line
    if rm_comments:
        full_text = remove_comments(full_text)
    return full_text


def obfuscation(line, variables):
    """ Change names of identifiers (variables, methods, classes, etc.) """
    for key, value in variables.items():
        line = re.sub(r"\b" + key + r"\b", value, line)
        # line = line.replace(key, value)
    return line


def remove_comments(string):
    """ Remove Comments from file represented as a string """
    # remove all occurance streamed comments (/*COMMENT */) from string
    string = re.sub(re.compile("/\*.*?\*/", re.DOTALL), "", string)
    # remove all occurance singleline comments (//COMMENT\n ) from string
    string = re.sub(re.compile("//.*?\n"), "", string)
    return string


def remove_blank_lines(line):
    """ Remove all blank lines from the list """
    line_trimmed = line.strip()
    if not line_trimmed:
        return ""
    return line


def add_blank_lines():
    """ Randomly adds blank lines """
    if random.choice([True, False]):
        return "\n"
    return ""


def keyword_dictonary(keys):
    """ Generate a dictonary where keys are identifiers (variables or method names)
        and values are the random string of characters which has length of 10 chars """
    keys = list(set(keys))
    counter = 0
    all_keywords = {}
    for item in keys:
        if item[0] == '\"' and item[len(item)-1] == '\"':
            all_keywords[item[1:-1]] = random_string()
            # all_keywords[item] = '\"' + random_string() + '\"'
        else:
            all_keywords[item] = random_string()
        counter += 1
    return all_keywords


def random_string(string_length=10):
    """ Generate a random string of fixed length """
    letters = string.ascii_uppercase
    return ''.join(random.choice(letters) for i in range(string_length))


def load_file(filename):
    """ Loads file and read all line which are return as a list """
    with open(filename) as file:
        return file.readlines()


def save_text_to_file(filename, obfuscated_text):
    """ Save obfuscated text to the file (if file exists, file is overwritten) """
    with open(filename, "w") as file:
        file.write(''.join(obfuscated_text))


def cli_tool(filename_in, filename_out, obfuscate=False, blanks=None, remove_comments=False):
    """ Command Line Tool Interface"""
    print(filename_in)
    variables = keyword_dictonary(get_identifieres(filename_in))
    loaded = load_file(filename_in)
    processed = process(loaded, variables, obfuscate=obfuscate,
                        blanks=blanks, rm_comments=remove_comments)
    save_text_to_file(filename_out, processed)


def obfuscator(filename, obfuscate=False, blanks=None, remove_comments=False):
    """ 
    Using of the obfuscation tool 
    - Obfuscation
    - Removing Comments
    - Adding or Removing Blank lines ('add', 'remove')
    Return: String - Obfuscated string
    """
    variables = keyword_dictonary(get_identifieres(filename))
    loaded = load_file(filename)
    return process(loaded, variables, obfuscate=obfuscate,
                   blanks=blanks, rm_comments=remove_comments)

# """ Implementation Test code """
# filename_in = "test.java"
# filename_out = "test2.java"
# cli_tool(filename_in, filename_out, obfuscate=True,
#          blanks='remove', remove_comments=True)


# variables = keyword_dictonary(get_identifieres(filename))
# loaded = load_file(filename)
# processed = process(loaded, variables, obfuscate=True,
#                     blanks='add', rm_comments=True)
# save_text_to_file(filename_out, processed)

# key_dict = keyword_dictonary(get_identifieres(filename))
# loaded = load_file(filename)
# processed = process(loaded, key_dict, obfuscate=True,
#                     blanks='add', remove_comments=False)
# save_text_to_file(filename_out, processed)
