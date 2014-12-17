Digital-Image-Processor
=======================

This project IMAGE PROCESSING SYSTEM aims at enhancing  raw  images received from cameras/sensors placed on satellites, space probes and aircrafts or pictures taken in normal day-to-day life for various applications. What is detailed below are the functionalities which constituted the basic idea behind the project of image manipulation. This does not explain the framework necessarily but gives a skeletal viewpoint of the whole project. We also developed a near-real-time computer project that can locate and track a subject’s head, and then recognize the person by comparing characteristics of the face to those of known individuals. Our approach treats the face recognition problem as a two-dimensional (2-D) recognition problem, taking the advantage of the fact that faces are normally upright. The system functions by projecting the face images onto a feature space that spans the significant variations among known face images. The significant features are known as “Eigenfaces,” which may be thought of as eigenvectors/patternvectors (the principal components) of the initial training set of face images; they do not correspond to features such as eyes, ears and noses. Pattern vectors corresponding to multiple poses build a trajectory/projection in eigenspace where each trajectory belongs to one face sequence (profile to profile). The projection operation characterizes an individual face by a weighted sum of the Eigenfaces features, and so to recognize a particular face it is necessary only to compare these weights to those known individuals. Computers that recognize faces could be applied to a wide variety of problems, including criminal identification, security systems, image and film processing and human-computer interaction. For example, the ability to model a particular face and distinguish it from a large number of stored face models would make it possible to vastly improve criminal identification.

Proposed System Features & Modules:-
•	ImagePanel
•	PrintUtilities
•	ImageProcessor
•	SwingComp
•	InfoFrame
In our project we add the basic effects to the image that is taken or is downloaded. The various effects included at initial level:
•	Brightness:  For altering the brightness and contrast of the Image.
•	Edge detect: For enhancing the details found in the edge of the image
•	Blur: For blending together pixels of the image.
•	Sharpen: For creating more contrast between neighboring pixels.
•	Negative: For making the white areas black and black areas white.
•	Rotate: For rotating the image at an angle.
•	Other special effects also included such as darkening, enlarging, shrinking, contrasting, flipping etc.
•	Applying color inversion and color filtering.
