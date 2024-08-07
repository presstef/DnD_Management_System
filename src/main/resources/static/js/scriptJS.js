document.addEventListener('DOMContentLoaded', function() {
    const elements = document.querySelectorAll('.form-group *');
    elements.forEach(element => {
        if (element.tagName.toLowerCase() === 'select') {
            element.selectedIndex = -1;
        }
    });
});