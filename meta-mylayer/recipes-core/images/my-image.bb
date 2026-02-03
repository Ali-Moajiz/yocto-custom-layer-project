SUMMARY = "My Custom Test Image"

require recipes-core/images/core-image-base.bb

IMAGE_INSTALL += " \
    packagegroup-core-boot \
    hello \
"

