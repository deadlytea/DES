DES
===

Java implementation of DES for university cryptography course, only ECB mode is implemented (weak I know..)

Mostly used BigInteger class and String Manipulation to do bit operations

DES is the [Data Encryption Standard](http://en.wikipedia.org/wiki/Data_Encryption_Standard), predecessor of the AES block cipher widely used today

It is 64-bit and as specified in [FIPS Pub 46](http://csrc.nist.gov/publications/fips/fips46-3/fips46-3.pdf)

To Run
------
Download the DES.java file

Open Terminal and cd into directory you downloaded to

eg. ```cd ~/Downloads/DES```

Compile the java file

```javac -c DES.java```

Now you can run with 

```javaw DES.jar -k1 <key> -m <message_to_encrypt>```

and the program will print the encrypted message to standard output

Options
-------
To Decrypt simply add the ```-d``` option

eg. ```javaw DES.jar -d -k1 <key> -m <message_to_decrypt>```

To use [TripleDES](http://en.wikipedia.org/wiki/Triple_DES) encryption provide three keys like so:

```javaw DES.jar -k1 <key1> -k2 <key2> -k3 <key3> -m <message_to_encrypt>```

And for decryption again use ```-d```:

```javaw DES.jar -d -k1 <key1> -k2 <key2> -k3 <key3> -m <message_to_decrypt>```


