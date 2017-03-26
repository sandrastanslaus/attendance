<?php
require "init.php";

//retrieve information from the table

$name= $_POST ["username"];
$password=$_POST["password"];

$sql_query= "SELECT * FROM students WHERE username='$name' AND password='$password' LIMIT 1;";

echo "<br>";    // this is for line break

//execute query

$result = mysqli_query($connection, $sql_query);

if(mysqli_num_rows($result)>0)
{
	$row= mysqli_fetch_assoc($result);
	$name=$row ["username"];

	echo "login Success.... ";
}

else
{
	echo "login failed... try again";
}





?>