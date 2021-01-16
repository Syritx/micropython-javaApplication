import subprocess

def write_data(file, dat):
    f = open(file, 'w+')
    f.write(dat)

def split_command(message, buffer):
    commands = str(message).split(buffer)
    for i in commands:
        print(i)
        if i == '[create_software]':
            subprocess.call(['sh', './software/main.sh'])

        if i.startswith('[humidity]:'):
            h = float(i.split('[humidity]:')[1])
            write_data('dat/humid.txt', str(h))

        if i.startswith('[temperature]:'):
            t = float(i.split('[temperature]:')[1])
            write_data('dat/temp.txt', str(t))