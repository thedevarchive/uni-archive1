<html>
    <body>
        <?php 
        //define a string
        $string = "one,two"; 
        //break the string based on a separator "," as two parts $a and $b 
        list($a, $b) = explode(",", $string);
        //print $a
        echo $a; 
        echo "<br/>"; 
        //print b 
        echo $b; 
        ?>
    </body>
</html>