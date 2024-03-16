#include <iostream>
#include <clocale>

const wchar_t heart[] = L"\u2665";

int main() {
    setlocale(LC_ALL, "");
    std::wcout << heart << L'\n';
    return 0;
}