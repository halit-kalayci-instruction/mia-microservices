# İstekleri depolamak için bir liste oluştur
$jobs = @()

# Asenkron olarak her isteği gönder ve işleri başlat
for ($i = 1; $i -le 10; $i++) {
    $scriptBlock = {
        param($i)
        $response = & curl.exe -s --header "Connection: close" http://127.0.0.1:57374/api/base
        if ($response -match "Pod: (.+?), IP: (.+?) - Received message from other service:(.+)") {
            $podName = $matches[1]
            $ip = $matches[2]
            $message = $matches[3]
            "Istek $i, Yonlendirildigi IP: $ip , Pod Name: $podName, Servis 2: $message"
        } else {
            "Istek $i, Yanıt alınamadı"
        }
    }
    Write-Output "$i. istek atiliyor."
    $jobs += Start-Job -ScriptBlock $scriptBlock -ArgumentList $i
}

# İşlerin tamamlanmasını bekle ve sonuçları topla
$jobs | ForEach-Object {
    $result = Receive-Job -Job $_ -Wait
    Write-Output $result
    Remove-Job -Job $_
}
