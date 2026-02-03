# Getting Started with Yocto: Adding a Custom Layer and Building from a Custom Recipe
A learning-oriented project designed to explore the fundamentals of the Yocto Project. Unlike standard tutorials that rely on Poky's default `core-image-minimal`, this project demonstrates how to manage a custom layer outside of Poky and build a Linux image from a custom recipe.

## Project Motive

The primary goal of this repository is to provide a hands-on understanding of:

* Version Control Management: Handling Yocto projects using `kas` for automated repository management.
* Custom Layer Integration: Adding and managing a custom metadata layer outside the standard Poky tree.
* Custom Image Creation: Using a custom recipe (`my-image.bb`) to generate the Linux image and file systems instead of using the default minimal images.
* Init Automation: Running a custom-compiled program automatically upon system boot.

## Getting Started

Follow the sequence below to clone the project, build the environment, and run the image in a QEMU virtual machine.

### 1. Clone the Repository

```bash
git clone https://github.com/Ali-Moajiz/starting-yocto
cd starting-yocto
```

### 2. Build the Project

We use `kas` to handle layer fetching and build configuration. This command will clone all required repositories and generate the entire Linux image.

```bash
kas build project-kas.yml
```

### 3. Initialize the Environment

Once the build completes, move into the poky directory and source the OpenEmbedded environment script:

```bash
cd poky
source oe-init-build-env
```

### 4. Run the Image

Yocto provides a QEMU script to run the VM inside the yocto directory. Boot your custom Linux image using QEMU. The `nographic` flag is used to run the VM directly in your terminal:

```bash
cd ..
cd build
runqemu qemuarm64 nographic
```

Your virtual machine will boot, and you can explore the generated system and verify the execution of your custom program.

### 5. Log in  with "root" and run the Hello Application (to see if the required added application is running)

A custom `hello` application installed in the ``usr/bin``directory of the file system. you will see the output `Hello from My Yocto Layer!`
```bash
hello

```

## Key Components

* `meta-custom`: The custom layer containing your logic.
* `recipes-core/images/my-image.bb`: The main recipe used to build the custom image.
* `project-kas.yml`: The configuration file for the `kas` build tool.

Happy Building!
