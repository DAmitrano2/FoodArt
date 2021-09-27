<!--
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	-->
	<%@include file="./include/header.jsp"%>
	<!--
    <link rel="stylesheet" href="./assets/css/single_product.css">
    <link rel="stylesheet" href="./assets/css/index_style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css">
	-->
    <section class="container sproduct my-5 pt-5">
        <div class="row mt-5">
            <div class="col-lg-5 col-md-12 col-12">
                <img class="img-fluid w-100 pb-1" src="images/primaprodottosingolo.jpg" id="MainImg" alt="">
                <div class="small-img-group">
                    <div class="small-img-col">
                        <img src="images/primaprodottosingolo.jpg" width="100%" class="small-img" alt="">
                    </div>
                    <div class="small-img-col">
                        <img src="images/secondaprodottosingolo.jpg" width="100%" class="small-img" alt="">
                    </div>
                    <div class="small-img-col">
                        <img src="images/terzaprodottosingolo.jpg" width="100%" class="small-img" alt="">
                    </div>
                    <div class="small-img-col">
                        <img src="images/quartaprodottosingolo.jpg" width="100%" class="small-img" alt="">
                    </div>
                </div>
            </div>
            <div class="col-lg-6 col-md-12 col-12">
                <h3>Confettura di Albicocche</h3>
                <h6>da <a href="#">Societ&#224 Agricola Amitrano</a></h6>
                <div class="rating">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="far fa-star"></i>
                </div>
				<hr>
                <h2>&#8364 6.00 al pz</h2>
                <select class="my-3">
                    <option>Seleziona la quantità</option>
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                </select>
                <button type="button" class="btn bg-cart"><i class="fas fa-cart-plus mr-2"></i>Aggiungi al Carrello</button>
                <h4 class="mt-3 mb-2">Dettagli sul Prodotto</h4>
                <span>Raccolte in Campania, tra giugno e luglio, le nostre albicocche sono dei frutti dolci
					dalla polpa tenera, ricche di antiossidanti e dal basso contenuto calorico. Realizzata con
					albicocche del genere <i>Prunus</i>, composta anche da zucchero, succo di limone e pectine.
					Conservata in un vasetto di vetro. Dopo l'apertura conservare in frigorifero e consumare dopo
					pochi giorni. 
				</span>
            </div>
        </div>
    </section>
    
	<div class="small-container justify-content-center">
    <h2 class="title">Prodotti Correlati</h2>
	<div class="row">
		<div class="col-4 text-center">
			<img src="images/prodottocorrelato1.jpg" alt="">
			<h4>Confettura di Fragole</h4>	
			<span href="test.jsp">SOCIET&#192; AGRICOLA AMITRANO</span>
			<div class="rating">
				<i class="fas fa-star"></i>
				<i class="fas fa-star"></i>
				<i class="fas fa-star"></i>
				<i class="fas fa-star"></i>
				<i class="far fa-star"></i>
			</div>
			<p>&#8364; 6.00 al pz</p>
			<button type="button" class="btn bg-cart"><i class="fas fa-cart-plus mr-2"></i>Aggiungi al Carrello</button>
		</div>
		<div class="col-4 text-center">
			<img src="images/prodottocorrelato2.jpg" alt="">
			<h4>Confettura di Pesche</h4>
			<span>SOCIET&#192; AGRICOLA AMITRANO</span>
			<div class="rating">
				<i class="fas fa-star"></i>
				<i class="fas fa-star"></i>
				<i class="fas fa-star"></i>
				<i class="fas fa-star"></i>
				<i class="far fa-star"></i>
			</div>
			<p>&#8364; 6.00 al pz</p>
			<button type="button" class="btn bg-cart"><i class="fas fa-cart-plus mr-2"></i>Aggiungi al Carrello</button>
		</div>
		<div class="col-4 text-center">
			<img src="images/prodottocorrelato3.jpg" alt="">
			<h4>Confettura di Arance</h4>
			<span>SOCIET&#192; AGRICOLA AMITRANO</span>
			<div class="rating">
				<i class="fas fa-star"></i>
				<i class="fas fa-star"></i>
				<i class="fas fa-star"></i>
				<i class="fas fa-star-half-alt"></i>
				<i class="far fa-star"></i>
			</div>
			<p>&#8364; 6.00 al pz</p>
			<button type="button" class="btn bg-cart"><i class="fas fa-cart-plus mr-2"></i>Aggiungi al Carrello</button>
		</div>
		<div class="col-4 text-center">
			<img src="images/prodottocorrelato4.jpg" alt="">
			<h4>Miele Artigianale</h4>
			<span>SOCIET&#192; AGRICOLA AMITRANO</span>
			<div class="rating">
				<i class="fas fa-star"></i>
				<i class="fas fa-star"></i>
				<i class="fas fa-star"></i>
				<i class="fas fa-star"></i>
				<i class="fas fa-star-half-alt"></i>
			</div>
			<p>&#8364; 10.00 al pz</p>
			<button type="button" class="btn bg-cart"><i class="fas fa-cart-plus mr-2"></i>Aggiungi al Carrello</button>
		</div>
	</div>
</div>
<section id="testimonials">
	<div class="small-container justify-content-center">
		<h2 class="title">Recensioni in Evidenza</h2>
	<div class="testimonial-box-container">
		<div class="testimonial-box">
			<div class="box-top">
				<div class="profile">
					<div class="profile-img">
						<img src="images/recensione1.jpg" alt="">
					</div>
				</div>
				<div class="user-informations">
				<div class="title-review">
					<div class="rating">
						<i class="fas fa-star"></i>
						<i class="fas fa-star"></i>
						<i class="fas fa-star"></i>
						<i class="fas fa-star"></i>
						<i class="fas fa-star-half-alt"></i>
					</div>
					<strong>Buonissima</strong>
				</div>
				<div class="name-user">
					<span>Harry Potter</span>
				</div>
			</div>
			</div>
			<div class="client-comment">
				<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolorem, minus minima voluptatem iste sapiente similique perspiciatis temporibus laudantium nesciunt vel? Laudantium culpa tempore reiciendis ipsam aut ad voluptates voluptatem, incidunt qui ut ducimus aliquam neque eius excepturi quas modi eos quo maiores aperiam sequi, laborum ullam accusamus iste non. Aut?</p>
			</div>
		</div>
	</div>
	<div class="testimonial-box-container">
		<div class="testimonial-box">
			<div class="box-top">
				<div class="profile">
					<div class="profile-img">
						<img src="images/recensione2.jpg" alt="">
					</div>
				</div>
				<div class="user-informations">
				<div class="title-review">
					<div class="rating">
						<i class="fas fa-star"></i>
						<i class="fas fa-star"></i>
						<i class="fas fa-star"></i>
						<i class="fas fa-star"></i>
						<i class="far fa-star"></i>
					</div>
					<strong>Discreta</strong>
				</div>
				<div class="name-user">
					<span>Silvio Berlusconi</span>
				</div>
			</div>
			</div>
			<div class="client-comment">
				<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolorem, minus minima voluptatem iste sapiente similique perspiciatis temporibus laudantium nesciunt vel? Laudantium culpa tempore reiciendis ipsam aut ad voluptates voluptatem, incidunt qui ut ducimus aliquam neque eius excepturi quas modi eos quo maiores aperiam sequi, laborum ullam accusamus iste non. Aut?</p>
			</div>
		</div>
	</div>
	<div class="testimonial-box-container">
		<div class="testimonial-box">
			<div class="box-top">
				<div class="profile">
					<div class="profile-img">
						<img src="images/recensione3.jpg" alt="">
					</div>
				</div>
				<div class="user-informations">
				<div class="title-review">
					<div class="rating">
						<i class="fas fa-star"></i>
						<i class="fas fa-star"></i>
						<i class="fas fa-star"></i>
						<i class="fas fa-star"></i>
						<i class="fas fa-star"></i>
					</div>
					<strong>Fenomenale</strong>
				</div>
				<div class="name-user">
					<span>Elon Musk</span>
				</div>
			</div>
			</div>
			<div class="client-comment">
				<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolorem, minus minima voluptatem iste sapiente similique perspiciatis temporibus laudantium nesciunt vel? Laudantium culpa tempore reiciendis ipsam aut ad voluptates voluptatem, incidunt qui ut ducimus aliquam neque eius excepturi quas modi eos quo maiores aperiam sequi, laborum ullam accusamus iste non. Aut?</p>
			</div>
		</div>
	</div>
</div>
</section>
<%@include file="./include/script.html" %>



