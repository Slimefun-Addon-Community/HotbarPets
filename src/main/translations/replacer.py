import json
import os
import sys

#######################
### Made by ChatGPT ###
#######################

def load_json(filename):
    try:
        with open(filename, encoding='utf-8') as f:
            return json.load(f)
    except (IOError, json.JSONDecodeError) as e:
          print(f"Error loading JSON file '{filename}': {str(e)}")
          sys.exit(1)

def replace_in_file(filename, replacements, count_dict, simulate=False):
    with open(filename, 'r', encoding='utf-8') as f:
        content = f.read()
    for key, value in replacements.items():
        if not key.startswith('comment') and '${' + key + '}' in content:
            if not simulate:
                content = content.replace('${' + key + '}', value)
            count_dict[key] += 1
    if not simulate:
        with open(filename, 'w', encoding='utf-8') as f:
            f.write(content)

def replace_in_directory(directory, replacements, simulate=False):
    if simulate:
        print("Simulate Replace ON")
    count_dict = {key: 0 for key in replacements if not key.startswith('comment')}
    for root, dirs, files in os.walk(directory):
        for file in files:
            if file.endswith('.java'):
                path = os.path.join(root, file)
                replace_in_file(path, replacements, count_dict, simulate=simulate)
    total_keys = len(replacements) - len([key for key in replacements if key.startswith('comment')])
    success_keys = len([count for count in count_dict.values() if count > 0])
    success_percentage = success_keys / total_keys * 100
    print(f"Replaced {success_keys}/{total_keys} keys ({success_percentage:.2f}%) successfully.")
    not_replaced = [key for key, count in count_dict.items() if count == 0]
    if not_replaced:
        print("The following keys were not replaced:")
        for key in not_replaced:
            print(key)

if __name__ == '__main__':
    json_file = "src/main/translations/translations_zh_TW.json"
    directory = "src/"
    replacements = load_json(json_file)
    simulate = False
    replace_in_directory(directory, replacements, simulate=simulate)