class App {
    static DOMAIN = location.origin;

    static BASE_URL_AUTH = this.DOMAIN + "/api/auth";

    static BASE_URL_APARTMENT = this.DOMAIN + "/api/apartments";

    static BASE_URL_NEW_APARTMENT = this.DOMAIN + "/api/apartments/create";

    static BASE_URL_APARTMENT_TYPE = this.DOMAIN + "/api/apartmentType";

    static BASE_URL_BOOKING = this.DOMAIN + "/api/booking"

    static ERROR_400 = "Please check the data!";
    static ERROR_401 = "Please log in to perform this function.";
    static ERROR_403 = "You are not authorized to perform this function.";
    static ERROR_404 = "An error occurred. Please try again later!";
    static ERROR_500 = "Save information fail, please contact administration.";


    static showSuccessAlert(t) {
        Swal.fire({
            icon: 'success',
            title: t,
            position: 'top-end',
            showConfirmButton: false,
            timer: 1500
        })
    }

    static showErrorAlert(t) {
        Swal.fire({
            icon: 'error',
            title: 'Warning',
            text: t,
        })
    }

    static showConfirmDelete() {
        return Swal.fire({
            title: 'Are you sure to delete this property?',
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it!'
        })
    }

    static showError401() {
        Swal.fire({
            icon: 'error',
            title: 'Access Denied',
            text: 'Invalid credentials!',
        })
    }

    static showError403() {
        Swal.fire({
            icon: 'error',
            title: 'Access Denied',
            text: 'You are not authorized to perform this function!',
        })
    }

    static formatNumber() {
        $(".num-space").number(true, 0, ',', ' ');
        $(".num-point").number(true, 0, ',', '.');
        $(".num-comma").number(true, 0, ',', ',');
    }

    static formatNumberSpace(x) {
        if (x == null) {
            return x;
        }
        return x.toString().replace(/ /g, "").replace(/\B(?=(\d{3})+(?!\d))/g, " ");
    }

    static removeFormatNumberSpace(x) {
        if (x == null) {
            return x;
        }
        return x.toString().replace(/ /g, "")
    }

    static IziToast = class  {
        static showSuccessAlert(m) {
            iziToast.success({
                title: 'Success',
                position: 'topRight',
                timeout: 2000,
                message: m,
            });
        }

        static showErrorAlert(m) {
            iziToast.error({
                title: 'Error',
                position: 'topRight',
                timeout: 2000,
                message: m,
            });
        }
    }

}

class User {
    constructor(id, username, password, role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }
}

class Role {
    constructor(id, code, name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }
}
class ApartmentTypeDTO {
    constructor(id, name) {
        this.id = id;
        this.name = name;
    }
}

class Apartment {
    constructor(id, title, apartmentTypeDTO, area, price, description, kitchen, balcony, view, petAllowed) {
        this.id = id;
        this.title = title;
        this.apartmentTypeDTO = apartmentTypeDTO;
        this.area = area;
        this.price = price
        this.description = description;
        this.kitchen = kitchen;
        this.balcony = balcony;
        this.view = view;
        this.petAllowed = petAllowed;
    }
}

class Booking {
    constructor(id, checkInDate, checkOutDate, apartment, tenantName, tenantEmail, tenantPhone) {
        this.id = id;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.apartment = apartment;
        this.tenantName = tenantName;
        this.tenantEmail = tenantEmail;
        this.tenantPhone = tenantPhone;

    }
}







