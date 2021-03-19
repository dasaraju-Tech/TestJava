<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>A Verifiable Semantic Searching Scheme by Optimal Matching over Encrypted Data in Public Cloud - Index</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/jts.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/icofont/icofont.min.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
  <link href="assets/vendor/venobox/venobox.css" rel="stylesheet">
  <link href="assets/vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">


</head>

<body>

  <!-- ======= Header ======= -->
  <header id="header" class="fixed-top ">
    <div class="container-fluid">
      <div class="row justify-content-center">
        <div class="col-xl-10 d-flex align-items-center justify-content-between">

          <h1 class="logo"><a href="index.html">CLOUD COMPUTING</a></h1>

          <nav class="nav-menu d-none d-lg-block">
            <ul>
              <li class="active"><a href="CloudHomePage.jsp"><h5>Home Page</h5></a></li>
              <li><a href="viewDataOwners.jsp"><h5>View Data Owners</h5></a></li>
              <li><a href="viewDataUsers.jsp"><h5>View Data Users</h5></a></li>
              <li><a href="viewFiles.jsp"><h5>View Files</h5></a></li>
              <li><a href="viewTopKFiles.jsp"><h5>View Top-K-Files</h5></a></li>
              <li><a href="LogoutServlet"><h5>Logout</h5></a></li>
            </ul>
            
          </nav>
          

        </div>
      </div>

    </div>
  </header>
  
  <!-- End Header -->

  <!-- ======= Hero Section ======= -->
  <section id="hero">
    <div id="heroCarousel" data-bs-interval="5000" class="carousel slide carousel-fade" data-bs-ride="carousel">

      <ol class="carousel-indicators" id="hero-carousel-indicators"></ol>

      <div class="carousel-inner" role="listbox">

        <!-- Slide 1 -->
        <div class="carousel-item active" style="background-image: url(assets/img/slide/cloud1.jpg)">
          <div class="carousel-container">
            <div class="container">
              <h2 class="animated fadeInDown">Welcome to <span>Cloud Computiong</span></h2>
              <p class="animated fadeInUp">Cloud computing is the on-demand availability of computer system resources, especially data storage (cloud storage)
               and computing power, without direct active management by the user. The term is generally used to describe data centers available to many users over the Internet.
                Large clouds, predominant today, 
              often have functions distributed over multiple locations from central servers. If the connection to the user is relatively close
              , it may be designated an edge server.</p>
              <a href="#about" class="btn-get-started animated fadeInUp scrollto">Read More</a>
            </div>
          </div>
        </div>

        <!-- Slide 2 -->
        <div class="carousel-item" style="background-image: url(assets/img/slide/cloud2.jpg)">
          <div class="carousel-container">
            <div class="container">
              <h2 class="animated fadeInDown"></h2>
              <p class="animated fadeInUp">
              
              Though service-oriented architecture advocates "Everything as a service", 
              cloud-computing providers offer their "services" according to different models, of which the three standard models per NIST are 
              Infrastructure as a Service (IaaS), Platform as a Service (PaaS), and Software as a Service (SaaS).These models offer increasing abstraction; 
              they are thus often portrayed as layers in a stack: infrastructure-, platform- and software-as-a-service, but these need not be related. For example, one 
              can provide SaaS implemented on physical machines
              (bare metal), without using underlying PaaS or IaaS layers, and conversely one can run a program on IaaS and access it directly, without wrapping it as SaaS.
              <br>
              <a href="#about" class="btn-get-started animated fadeInUp scrollto">Read More</a>
            </div>
          </div>
        </div>

        <!-- Slide 3 -->
        <div class="carousel-item" style="background-image: url(assets/img/slide/cloud3.jpg)">
          <div class="carousel-container">
            <div class="container">
              <h2 class="animated fadeInDown">Cloud Architecture</h2>
              <p class="animated fadeInUp">
              Cloud architecture,the systems architecture of the software systems involved in the delivery of cloud computing, typically 
              involves multiple cloud components communicating with each other over a loose coupling mechanism such as a messaging queue. 
              Elastic provision implies intelligence in the use of tight or loose coupling as applied to mechanisms such as these and others.
              
              
              <a href="#about" class="btn-get-started animated fadeInUp scrollto">Read More</a>
            </div>
          </div>
        </div>

      </div>

      <a class="carousel-control-prev" href="#heroCarousel" role="button" data-bs-slide="prev">
        <span class="carousel-control-prev-icon icofont-simple-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>

      <a class="carousel-control-next" href="#heroCarousel" role="button" data-bs-slide="next">
        <span class="carousel-control-next-icon icofont-simple-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>

    </div>
  </section>

  <main id="main" align="center">
 
 <div class="container" align="center" style="width:35%;">
<div class="jumbotron">
  
  <section>
  <h1><b>welcome:${message}</b></h1>
  
  Semantic searching over encrypted data is a crucial task for secure information
   retrieval in public cloud. It aims to provide retrieval service to arbitrary words so that 
   queries and search results are flexible. In existing semantic searching schemes, the verifiable 
   searching does not be supported since it is dependent on the forecasted results from predefined keywords to verify 
   the search results from cloud, and the queries are expanded on plaintext and the exact matching is performed by the 
   extended semantically words with predefined keywords, which limits their accuracy. In this paper, we propose a secure verifiable
    semantic searching scheme. For semantic optimal matching on ciphertext, we formulate word transportation (WT) problem to calculate 
    the minimum word transportation cost (MWTC) as the similarity between queries and documents, and propose a secure transformation to 
    transform WT problems into random linear programming (LP) problems to obtain the encrypted MWTC. For verifiability, we explore the 
    duality theorem of LP to design a verification mechanism using the intermediate data produced in matching process to verify the correctness 
    of search results. Security analysis demonstrates
   that our scheme can guarantee verifiability and confidentiality. Experimental results on two datasets show our scheme has higher accuracy than other schemes.
  
  
  </section>



   

    </div></div>

  </main>
  

  <!-- ======= Footer ======= -->
  <footer id="footer">

    



    <div class="container">
      
      <div class="copyright">
        &copy; Copyright<strong><span>  JTS</span></strong>. All Rights Reserved
      </div>
     
      <div class="credits">
        Designed by <a href="https://jignasatech.com/">Jignasa Techno Solutions</a>
      </div>
      
    </div>
  </footer><!-- End Footer -->

  <div id="preloader"></div>
  <a href="#" class="back-to-top"><i class="icofont-simple-up"></i></a>

  <!-- Vendor JS Files -->
  <script src="assets/vendor/jquery/jquery.min.js"></script>
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/jquery.easing/jquery.easing.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>
  <script src="assets/vendor/venobox/venobox.min.js"></script>
  <script src="assets/vendor/waypoints/jquery.waypoints.min.js"></script>
  <script src="assets/vendor/counterup/counterup.min.js"></script>
  <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="assets/vendor/owl.carousel/owl.carousel.min.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>

</body>

</html>