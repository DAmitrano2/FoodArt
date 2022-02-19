<%@include file="./include/header.jsp"%>
<div class="container">
    <div class="d-flex justify-content-center">
        <div class="col-sm-6">
            <div class="card" id="product-card">
                <div class="card-header">
                    <strong>Inserisci un nuovo prodotto</strong>
                </div>
                <div class="card-body">
                    <div class="row justify-content-center">
                        <label for="image-picker">
                            <img class="img-fluid" id="image-preview" src="<%=path%>/assets/images/default-background.jpg" alt="your image" />
                        </label>
                        <input id="image-picker" type="file" accept="image/*" />
                        <!--
                        <div class="profile">
                            <input name="fProfilo" type="file" class="form-control" accept=".jpg, .jpeg, .png" id="fProfilo"/>					
                            <label for="fProfilo" class="custom-file-upload form-control profile-img-add" id="preview-image-box">
                                <div class="address-plus preview-default"></div>
                            </label>
                        </div>
                        -->
                    </div>
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="form-group">
                                <label for="name">Titolo</label>
                                <input class="form-control" name="name" type="text">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="form-group">
                                <label for="name">Categoria</label>
                                <select name="category" class="form-control" id="category">
                                    <option id="categoryOption" value="cn">Carne</option>
                                    <option id="categoryOption" value="ps">Pesce</option>
                                    <option id="categoryOption" value="cd">Cereali e Derivate</option>
                                    <option id="categoryOption" value="ld">Latte, Derivati e Uova</option>
                                    <option id="categoryOption" value="pa">Pasticceria</option>
                                    <option id="categoryOption" value="fr">Frutta e Verdura</option>
                                    <option id="categoryOption" value="bv">Bevande</option>
                                    <option id="categoryOption" value="cs">Conserve</option>
                                    <option id="categoryOption" value="co">Condimenti</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="addInfo">Descrizione</label>
                        <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" placeholder="Una breve descrizione del prodotto" style="resize: none;"></textarea>
                      </div>
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label for="cap">Prezzo</label>
                                <input class="form-control" name="cap" type="text" placeholder="&#8364;">
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label for="city">Unit&#224; di misura</label>
                                <select name="unmeasure" class="form-control" id="unmeasure">
                                    <option id="unmeasureOption" value="pz">Pezzo</option>
                                    <option id="unmeasureOption" value="kg">Litro</option>
                                    <option id="unmeasureOption" value="lt">Chilo</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label for="province">Quantit&#224;</label>
                                <input class="form-control" name="province" type="number" value="1" min="1">
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label for="tnumber">Quantit&#224; minima di acquisto</label>
                                <input class="form-control" name="tnumber" type="number" value="1" min="1">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card-footer">
                    <button class="btn float-right" type="submit">Invia</button>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="<%=path%>/assets/js/add_product.js"></script>
<%@include file="./include/footer.html"%>
<%@include file="./include/script.jsp"%>