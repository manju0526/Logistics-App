/**
 * Prepared by Manjunath Y on 01-01-2025
 */
function isEmpty(element) {
    var s = element.value;  // Get the value of the element
    for (var i = 0; i < s.length; i++) {  // Iterate over each character in the string
        var c = s.charAt(i);  // Get the current character
        if (c != " ") {  // If the character is not a space
            return false;  // Return false immediately if any non-space character is found
        }
    }
    element.value = "";  // Clear the value if it's empty or only contains spaces
    return true;  // Return true if only spaces or empty
}
