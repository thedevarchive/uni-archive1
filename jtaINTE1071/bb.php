<html>
    <body>
        We assume there is a table in the database, named test.text
        <br/><br/>

        <?php
            //open a file name "test.txt"
            $file = fopen("test.txt", "w"); //"w"=overwrite
            $anything = "hello world!";
            //lwrite into thte users.txt file
            fwrite($file, $anything);
            //close the file
            fclose($file);
        ?>
    Done! Check the test.txt file
    </body>
</html>