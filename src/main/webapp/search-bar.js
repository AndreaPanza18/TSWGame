function searchFunction() {
    const query = document.getElementById('search').value.toLowerCase();

    if (query.length < 2) {
        document.getElementById('results').innerHTML = '';
        return;
    }

    const xhr = new XMLHttpRequest();
    xhr.open('GET', 'Games.txt', true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            const data = xhr.responseText.split('\n');
            const results = data.filter(item => item.toLowerCase().includes(query));
            displayResults(results);
        }
    };
    xhr.send();
}

function displayResults(results) {
    const resultsDiv = document.getElementById('results');
    resultsDiv.innerHTML = '';
    results.forEach(result => {
        const div = document.createElement('div');
        div.textContent = result;
        resultsDiv.appendChild(div);
    });
}

