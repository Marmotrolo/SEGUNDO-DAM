document.getElementById('registroForm').addEventListener('submit', function (e) {
    e.preventDefault();
    let valido = true;
  
    // Función auxiliar
    const mostrarError = (id, mensaje) => {
      document.getElementById(id).textContent = mensaje;
      valido = false;
    };
  
    // Resetear errores
    document.querySelectorAll('.error').forEach(el => el.textContent = '');
  
    const nombre = document.getElementById('nombre').value.trim();
    if (nombre.length < 2) mostrarError('errorNombre', 'El nombre debe tener al menos 2 caracteres.');
  
    const apellido = document.getElementById('apellido').value.trim();
    if (apellido.length < 2) mostrarError('errorApellido', 'El apellido debe tener al menos 2 caracteres.');
  
    const email = document.getElementById('email').value.trim();
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(email)) mostrarError('errorEmail', 'Correo inválido.');
  
    const telefono = document.getElementById('telefono').value.trim();
    if (!/^\d{9}$/.test(telefono)) mostrarError('errorTelefono', 'Teléfono debe tener 9 dígitos.');
  
    const edad = parseInt(document.getElementById('edad').value);
    if (isNaN(edad) || edad < 18 || edad > 99) mostrarError('errorEdad', 'Edad debe estar entre 18 y 99.');
  
    const password = document.getElementById('password').value;
    if (password.length < 6) mostrarError('errorPassword', 'Contraseña muy corta.');
  
    const confirmPassword = document.getElementById('confirmPassword').value;
    if (password !== confirmPassword) mostrarError('errorConfirmPassword', 'Las contraseñas no coinciden.');
  
    const fechaNacimiento = document.getElementById('fechaNacimiento').value;
    if (!fechaNacimiento) mostrarError('errorFechaNacimiento', 'Seleccione su fecha de nacimiento.');
  
    const genero = document.querySelector('input[name="genero"]:checked');
    if (!genero) mostrarError('errorGenero', 'Seleccione su género.');
  
    const terminos = document.getElementById('terminos').checked;
    if (!terminos) mostrarError('errorTerminos', 'Debe aceptar los términos.');
  
    if (valido) {
      alert('Formulario enviado con éxito ✅');
      this.reset();
    }
  });
  