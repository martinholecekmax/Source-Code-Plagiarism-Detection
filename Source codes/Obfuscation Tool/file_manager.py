import chardet
import os
import random
import shutil
import pandas
import re
import codecs
import sourcecode_tokenizer as tk

DATASET_FOLDER = "/Volumes/Untitled/Datasets/source-codes/batches2"
# MOVE_TO_DIRECTORY = "/Users/martinholecek/Desktop/Datasets/Dataset 1"
# MOVE_TO_DIRECTORY2 = "/Users/martinholecek/Desktop/Datasets/Dataset 2 (5 000)"
# MOVE_TO_DIRECTORY3 = "/Users/martinholecek/Desktop/Datasets/Dataset 3 (1 000)"
DATASET_20_0000 = "/Users/martinholecek/Desktop/Datasets/Small/Dataset_20000"
DATASET_50000 = "/Users/martinholecek/Desktop/Datasets/Small/Dataset_5000"
DATASET_20000 = "/Users/martinholecek/Desktop/Datasets/Small/Dataset_2000"
DATASET_A = "/Users/martinholecek/Desktop/Datasets/Dataset_A"
DATASET_CSV = "/Users/martinholecek/Desktop/Datasets/Small/dataset.csv"
DATASET_NEW = "/Users/martinholecek/Desktop/Datasets/Small/Dataset_New"


def get_file_data(dirname):
    for root, _, files in os.walk(dirname):
        for fname in filter(lambda fname: fname.endswith('.java'), files):
            yield open(os.path.join(root, fname), 'rb').read()


def get_file(abs_dir):
    for folder in os.listdir(abs_dir):
        yield os.path.join(abs_dir, folder)


def folder_random(directory):
    choice = random.choice(os.listdir(directory))
    return os.path.join(directory, choice)
    # return random.choice([x for x in os.listdir(directory)
    #                       if os.path.isdir(os.path.join(directory, x))])


def file_random(directory):
    choice = random.choice(os.listdir(directory))
    return choice
    # return os.path.join(directory, choice)
    # return random.choice([x for x in os.listdir(directory)
    #                       if os.path.isfile(os.path.join(directory, x))])


def move_files(source, destination):
    """Move files into subdirectories."""

    # move file to current dir
    shutil.copy(source, destination)
    print(f"File copied: {destination}")


def load_file_str(filename):
    with open(filename, encoding="ISO-8859-1") as file:
        return file.read()


def save_csv(filename_in, filename_out, mode='a'):
    """" Encode file to the csv (row for each file) """
    data = list(load_file_str(filename_in))
    data.insert(0, filename_in)
    df = pandas.DataFrame(data=[data])
    df.to_csv(filename_out, sep=',', index=False, header=False, mode=mode)
    print(f"File saved: {filename_in} into {filename_out}")


def save_csv_data(data, filename_out, mode='a'):
    """" Encode file to the csv (row for each file) """
    # data = list(load_file_str(filename_in))
    # data.insert(0, filename_in)
    df = pandas.DataFrame(data=[data])
    df.to_csv(filename_out, sep=',', index=False, header=False, mode=mode)
    print(f"File saved:")


def create_dataset(destination):
    generator = get_file(destination)
    for filename in generator:
        save_csv(filename, DATASET_CSV)

    # list_files = os.listdir(MOVE_TO_DIRECTORY)

    # content = list()
    # for i, filename in list_files:
    #     content.append(load_file_str(filename))
    #     if i % 100 == 0:
    #         save_csv_data(content, DATASET_CSV)
    #         content.clear()


def copy_files(source, destination):
    for _ in range(5100):
        directory = folder_random(source)
        # print(directory)
        filename = file_random(directory)
        while not filename.endswith('.java') or os.path.getsize(os.path.join(directory, filename)) > 2000:
            filename = file_random(directory)
        move_files(os.path.join(directory, filename),
                   os.path.join(destination, filename))


def copy_files_remove_comments(source, destination, number_files):
    num_files = 0
    while num_files != number_files:
        # Directories
        directory = folder_random(source)
        filename = file_random(directory)
        filename_in = os.path.join(directory, filename)

        # Files
        # filename = file_random(source)
        # filename_in = os.path.join(source, filename)

        filename_out = os.path.join(destination, filename)

        if filename.startswith('.'):
            continue
        full_text = ""
        try:
            with codecs.open(filename_in, 'rb', encoding='ascii') as file:
                lines = file.readlines()
                for line in lines:
                    if b"\x00" in line.encode('ascii') or "interface" in line or "abstract" in line:
                        # skip file that is interface or abstract or garbage
                        break
                    if line.startswith("import") or line.startswith("package") or "@" in line:
                        line = ""
                    full_text += remove_blank_lines(line)
                full_text = remove_comments(full_text).strip()
                counter = 0
                for _ in full_text:
                    counter += 1
                # if counter < 2000 and counter > 200:
                #     with codecs.open(filename_out, 'w') as file:
                #         file.write(full_text)
                #         file.flush()
                #         num_files += 1
                with codecs.open(filename_out, 'w') as file:
                    file.write(full_text)
                    file.flush()
                    num_files += 1
        except:
            print("File error", filename)


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


def calculate_max_chars(directory):
    """ Find a largerst file and get number of characters of this file """
    max_size = 0
    filename = ""
    filetext = ""
    for filename in os.listdir(directory):
        if filename.startswith('.'):
            continue
        try:
            full_filename = os.path.join(directory, filename)
            utf8_text = open(full_filename, 'r').read()
            # file_size = len(utf8_text.strip())
            counter = 0
            for _ in utf8_text:
                counter += 1
                if (counter > max_size):
                    max_size = counter
                    filename = full_filename
                    filetext = utf8_text
        except:
            print("Error reading", filename)
    return max_size, filename, filetext


## IMPLEMENTATION ##
# print(calculate_max_chars(DATASET_50000))
# copy_files_remove_comments(DATASET_FOLDER, DATASET_NEW, 20000)
# create_dataset()
