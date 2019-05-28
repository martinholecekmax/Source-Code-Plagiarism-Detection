import re
import pandas
import os
import file_manager as fm

MAX_SIZE = 200
MIN_SIZE = 180
progress = 1


def save_csv(filename_in, filename_out, data, mode='a'):
    """" Encode file to the csv (row for each file) """
    df = pandas.DataFrame(data=[data])
    df.to_csv(filename_out, sep=',', index=False, header=False, mode='a')
    # print(f"File saved: {filename_in}")


def parse():
    """ Depricated method """
    progress = 1
    regex_method = r"(?!class)(public|private)\s+([A-Za-z,\s*]){2,}\s*\([A-Za-z,\s*]*\)\s*\{[^\}]*\}"
    # regex_whitespace = r"\t|\n"
    regex_whitespace = r"\n"
    directory = "/Users/martinholecek/Desktop/Datasets/Small/Dataset_2000/"
    filename_out = "/Users/martinholecek/Desktop/Datasets/dataset1.csv"

    for filename in os.listdir(directory):
        if filename.startswith('.'):
            continue
        try:
            filename = os.path.join(directory, filename)
            with open(filename) as file:
                content = file.read()

                matches = re.finditer(regex_method, content, re.MULTILINE)

                for _, match in enumerate(matches, start=1):
                    method = re.sub(regex_whitespace, '', match.group())
                    print(method)
                    # print(len(method))
                    if len(method) <= MAX_SIZE and len(method) >= MIN_SIZE:
                        save_csv(filename, filename_out, method)
                        print(progress)
                        progress += 1
        except Exception as e:
            print(e)
            print("Error: ", filename, "could not be opened!")


def parse_file(filename_in, filename_out, progress):
    # progress = 1
    # regex_method = r"(?!class)(public|private)\s+([A-Za-z,\s*]){2,}\s*\([A-Za-z,\s*]*\)\s*\{[^\}]*\}"
    regex_method = r"(?!class)(public|private)\s+([A-Za-z,\s*]){2,}\s*\([A-Za-z,\s*]*\)\s*\{([^\}]*)\}"
    regex_whitespace = r"\s\s+|\n|\t"
    # regex_variables = r"\w+\s+(\w+)\s+\="

    try:
        # filename = os.path.join(directory, filename_in)
        with open(filename_in) as file:
            content = file.read()
            content = fm.remove_comments(content).strip()
            if "abstract" in content:
                # print("Abstract class error")
                return progress
            if "interface" in content:
                # print("Interface class error")
                return progress
            if b"\x00" in content.encode('ascii'):
                # print("Encoding error")
                return progress
            matches = re.finditer(regex_method, content, re.MULTILINE)
            # saved = False
            for _, match in enumerate(matches, start=1):
                method = re.sub(regex_whitespace, " ", match.group(3))
                # print(len(method))
                # print(method)
                # method = method.encode("ascii")
                if len(method) <= MAX_SIZE and len(method) >= MIN_SIZE:
                    # method_obf = method
                    # if progress % 2 == 0:
                    #     # print("obfuscated")
                    #     # Obfuscate variables
                    #     matches_obf = re.finditer(
                    #         regex_variables, method_obf, re.MULTILINE)

                    #     for _, match_v in enumerate(matches_obf, start=1):
                    #         method_obf = re.sub(
                    #             match_v.group(1), "XXXXX", method_obf)

                    save_csv(filename_in, filename_out,
                             method)
                    if progress % 10 == 0:
                        print("Progress :", progress)
                    # save_csv(filename_in, filename_out,
                    #          [1, method, method_obf])
                    # saved = True
                    progress += 1
                # if not saved:
                #     print("no matches")
            return progress
    except Exception:
        # except Exception as e:
        # print(e)
        # print("Error: ", filename_in, "could not be opened!")
        return progress


def parse_file_obffuscation(filename_in, filename_out, progress):
    # progress = 1
    # regex_method = r"(?!class)(public|private)\s+([A-Za-z,\s*]){2,}\s*\([A-Za-z,\s*]*\)\s*\{[^\}]*\}"
    regex_method = r"(?!class)(public|private)\s+([A-Za-z,\s*]){2,}\s*\([A-Za-z,\s*]*\)\s*\{([^\}]*)\}"
    regex_whitespace = r"\s\s+|\n|\t"
    regex_variables = r"\w+\s+(\b\w+\b)\s+\="

    try:
        with open(filename_in) as file:
            content = file.read()
            content = fm.remove_comments(content).strip()
            if "abstract" in content:
                # print("Abstract class error")
                return progress
            if "interface" in content:
                # print("Interface class error")
                return progress
            if b"\x00" in content.encode('ascii'):
                # print("Encoding error")
                return progress
            matches = re.finditer(regex_method, content, re.MULTILINE)
            for _, match in enumerate(matches, start=1):
                method = re.sub(regex_whitespace, " ", match.group(3))
                # print(len(method))
                # print(method)
                # method = method.encode("ascii")
                if len(method) <= MAX_SIZE and len(method) >= MIN_SIZE:
                    method_obf = method
                    # if progress % 2 == 0:
                    # print("obfuscated")
                    # Obfuscate variables
                    matches_obf = re.finditer(
                        regex_variables, method_obf, re.MULTILINE)

                    for _, match_v in enumerate(matches_obf, start=1):
                        method_obf = re.sub(
                            match_v.group(1), "XXXXX", method_obf)

                    # save_csv(filename_in, filename_out,
                    #          method)
                    save_csv(filename_in, filename_out,
                             [1, method, method_obf])
                    if progress % 10 == 0:
                        print("Progress :", progress)
                    progress += 1
            return progress
    except Exception:
        # except Exception as e:
        # print(e)
        # print("Error: ", filename_in, "could not be opened!")
        return progress


def create_dataset(source, destination, num_methods):
    progress = 0
    while progress != num_methods:
        # Directories
        directory = fm.folder_random(source)
        filename = fm.file_random(directory)
        filename_in = os.path.join(directory, filename)

        # print(filename)
        # print(filename_in)
        # break
        # filename_out = os.path.join(destination, filename)

        if filename.startswith('.'):
            continue

        progress = parse_file_obffuscation(filename_in, destination, progress)
        # if progress % 10 == 0:
        #     print("Progress :", progress)


DIRECTORY = "/Users/martinholecek/Desktop/Datasets/Small/Dataset_2000/"
FILENAME_OUT = "/Users/martinholecek/Desktop/Datasets/dataset_obfus.csv"
FILENAME_IN = "/Users/martinholecek/Desktop/Datasets/Small/Dataset_20000/TestHandle.java"
DATASET_FOLDER = "/Volumes/Untitled/Datasets/source-codes/batches2"

num_methods = 3000
create_dataset(DATASET_FOLDER, FILENAME_OUT, num_methods)
